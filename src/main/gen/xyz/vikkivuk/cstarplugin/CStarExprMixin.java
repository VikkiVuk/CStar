package xyz.vikkivuk.cstarplugin;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import xyz.vikkivuk.cstarplugin.psi.*;
import xyz.vikkivuk.cstarplugin.CStarType;

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
                                    if (unaryExpr.getInputStmt() == null) {
                                        if (unaryExpr.getNumber() != null) {
                                            type.set(CStarType.NUM);
                                        } else if (unaryExpr.getString() != null) {
                                            type.set(CStarType.LITERAL);
                                        } else if (unaryExpr.getText().equals("yes") || unaryExpr.getText().equals("no")) {
                                            type.set(CStarType.TRUTH);
                                        }
                                    } else {
                                        type.set(CStarType.LITERAL);
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
    }
}