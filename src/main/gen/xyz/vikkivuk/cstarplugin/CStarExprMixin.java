package xyz.vikkivuk.cstarplugin;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import xyz.vikkivuk.cstarplugin.psi.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public abstract class CStarExprMixin extends ASTWrapperPsiElement implements CStarExpr, CStarTypedElement {
    public CStarExprMixin(ASTNode node) {
        super(node);
    }

    @Override
    public CStarType getType() {
        AtomicReference<CStarType> type = new AtomicReference<>(CStarType.NONE);
        PsiElement firstChild = getFirstChild();
        if (firstChild.getNode().getElementType() == CStarTypes.CONCAT_EXPR) {
            ArrayList<CStarConcatExpr> concatExprs = new ArrayList<>(PsiTreeUtil.findChildrenOfType(this, CStarConcatExpr.class));
            for (CStarConcatExpr concatExpr : concatExprs) {
                concatExpr.getAddExprList().forEach(addExpr -> {
                    addExpr.getMulExprList().forEach(mulExpr -> {
                        mulExpr.getPrimaryList().forEach(unaryExpr -> {
                            if (type.get() == CStarType.LIST) {
                                return;
                            } else if (type.get() == CStarType.TABLE) {
                                return;
                            }

                            if (unaryExpr.getListLiteral() == null) {
                                if (unaryExpr.getTable() == null) {
                                    if (unaryExpr.getNumber() != null) {
                                        type.set(CStarType.NUM);
                                    } else if (unaryExpr.getString() != null) {
                                        if (unaryExpr.getString().getText().equals("yes") || unaryExpr.getString().getText().equals("no")) {
                                            type.set(CStarType.TRUTH);
                                        } else {
                                            type.set(CStarType.LITERAL);
                                        }
                                    }
                                } else {
                                    type.set(CStarType.TABLE);
                                }
                            } else {
                                type.set(CStarType.LIST);
                            }
                        });
                    });
                });
            }
        }

        return type.get();


//        if (firstChild == null) {
//            return CStarType.NONE;
//        }
//
//        // Check if it's a number literal
//        if (firstChild.getNode().getElementType() == CStarTypes.NUMBER) {
//            return CStarType.NUM;
//        }
//
//        // Check if it's a string literal
//        else if (firstChild.getNode().getElementType() == CStarTypes.STRING) {
//            return CStarType.LITERAL;
//        }
//
//        // Check if it's a boolean literal ('yes' or 'no')
//        else if (firstChild.getNode().getElementType() == CStarTypes.YES || firstChild.getNode().getElementType() == CStarTypes.NO) {
//            return CStarType.TRUTH;
//        }
//
//        // Check if it's an identifier (variable reference)
//        else if (firstChild.getNode().getElementType() == CStarTypes.IDENTIFIER) {
//            // Resolve the reference to find the variable declaration
//            PsiReference reference = firstChild.getReference();
//            if (reference != null) {
//                PsiElement resolved = reference.resolve();
//                if (resolved instanceof CStarVariableDeclaration) {
//                    return ((CStarVariableDeclaration) resolved).getType();
//                }
//            }
//        }

        // Handle more complex expressions as needed

    }
}