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

public class CStarStatementImpl extends ASTWrapperPsiElement implements CStarStatement {

  public CStarStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CStarVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CStarVisitor) accept((CStarVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CStarAssignment getAssignment() {
    return findChildByClass(CStarAssignment.class);
  }

  @Override
  @Nullable
  public CStarControlFlow getControlFlow() {
    return findChildByClass(CStarControlFlow.class);
  }

  @Override
  @Nullable
  public CStarFunctionCallStmt getFunctionCallStmt() {
    return findChildByClass(CStarFunctionCallStmt.class);
  }

  @Override
  @Nullable
  public CStarFunctionDeclaration getFunctionDeclaration() {
    return findChildByClass(CStarFunctionDeclaration.class);
  }

  @Override
  @Nullable
  public CStarPrintStmt getPrintStmt() {
    return findChildByClass(CStarPrintStmt.class);
  }

}
