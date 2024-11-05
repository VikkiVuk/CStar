package xyz.vikkivuk.cstarplugin;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;
import xyz.vikkivuk.cstarplugin.psi.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class CStarVariableDeclarationMixin extends ASTWrapperPsiElement implements PsiNameIdentifierOwner, CStarTypedElement {
    public CStarVariableDeclarationMixin(ASTNode node) {
        super(node);
    }

    @Override
    public PsiElement getNameIdentifier() {
        return findChildByType(CStarTypes.IDENTIFIER);
    }

    @Override
    public String getName() {
        PsiElement nameIdentifier = getNameIdentifier();
        return nameIdentifier != null ? nameIdentifier.getText() : null;
    }

    @Override
    public CStarType getType() {
        PsiElement typeElement = findChildByType(CStarTypes.TYPE);
        if (typeElement != null) {
            String typeText = typeElement.getText();
            return switch (typeText) {
                case "num" -> CStarType.NUM;
                case "truth" -> CStarType.TRUTH;
                case "literal" -> CStarType.LITERAL;
                case "list" -> CStarType.LIST;
                case "table" -> CStarType.TABLE;
                default -> CStarType.NONE;
            };
        } else {
            PsiElement parent = getParent();
            if (parent instanceof CStarAssignment assignment) {
                CStarExpr expr = assignment.getExpr();
                return expr.getType();
            } else if (parent instanceof CStarParameter parameter) {
                if (parameter.getText().startsWith("num")) {
                    return CStarType.NUM;
                } else if (parameter.getText().startsWith("truth")) {
                    return CStarType.TRUTH;
                } else if (parameter.getText().startsWith("literal")) {
                    return CStarType.LITERAL;
                } else if (parameter.getText().startsWith("list")) {
                    return CStarType.LIST;
                } else if (parameter.getText().startsWith("table")) {
                    return CStarType.TABLE;
                }
            } else if (parent instanceof CStarMarchStmt) {
                return CStarType.NUM;
            } else if (parent instanceof CStarEachStmt stmt) {
                if (stmt.getListLiteral() != null) {
                    AtomicReference<CStarType> type = new AtomicReference<>(CStarType.NONE);
                    if (stmt.getListLiteral().getExprList() == null) return CStarType.NONE;
                    stmt.getListLiteral().getExprList().getExprList().forEach(expr -> {
                        // we now need to check if its a list of numbers, literals or mixed. we will need to iterate through the list and check the type of each element and keep track of them and if theres only one type then return that, if theres more than one type then return mixed

                        expr.getConcatExpr().getAddExprList().forEach(addExpr -> {
                            addExpr.getMulExprList().forEach(mulExpr -> {
                                mulExpr.getPrimaryList().forEach(unaryExpr -> {
                                    if (unaryExpr.getNumber() != null) {
                                        if (unaryExpr.getListLiteral() == null) {
                                            if (type.get() == CStarType.NONE) {
                                                type.set(CStarType.NUM);
                                            } else if (type.get() != CStarType.NUM) {
                                                type.set(CStarType.MIXED);
                                            }
                                        } else {
                                            type.set(CStarType.MIXED);
                                        }
                                    } else if (unaryExpr.getString() != null) {
                                        if (unaryExpr.getListLiteral() == null) {
                                            if (unaryExpr.getString().getText().equals("yes") || unaryExpr.getString().getText().equals("no")) {
                                                if (type.get() == CStarType.NONE) {
                                                    type.set(CStarType.TRUTH);
                                                } else if (type.get() != CStarType.TRUTH) {
                                                    type.set(CStarType.MIXED);
                                                }
                                            } else {
                                                if (type.get() == CStarType.NONE) {
                                                    type.set(CStarType.LITERAL);
                                                } else if (type.get() != CStarType.LITERAL) {
                                                    type.set(CStarType.MIXED);
                                                }
                                            }
                                        } else {
                                            type.set(CStarType.MIXED);
                                        }
                                    }
                                });
                            });
                        });
                    });
                    return type.get();
                }
            }

            return CStarType.NONE;
        }
    }

    @Override
    public PsiElement setName(@NotNull String name) {
        // Implement renaming logic if necessary
        return this;
    }
}
