// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static xyz.vikkivuk.cstarplugin.psi.CStarTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import xyz.vikkivuk.cstarplugin.psi.*;

public class CStarPrimaryImpl extends ASTWrapperPsiElement implements CStarPrimary {

  public CStarPrimaryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CStarVisitor visitor) {
    visitor.visitPrimary(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CStarVisitor) accept((CStarVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CStarExpr getExpr() {
    return findChildByClass(CStarExpr.class);
  }

  @Override
  @Nullable
  public CStarFunctionCall getFunctionCall() {
    return findChildByClass(CStarFunctionCall.class);
  }

  @Override
  @Nullable
  public CStarListLiteral getListLiteral() {
    return findChildByClass(CStarListLiteral.class);
  }

  @Override
  @Nullable
  public CStarTable getTable() {
    return findChildByClass(CStarTable.class);
  }

  @Override
  @Nullable
  public CStarVariableReference getVariableReference() {
    return findChildByClass(CStarVariableReference.class);
  }

  @Override
  @Nullable
  public PsiElement getNumber() {
    return findChildByType(NUMBER);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

}
