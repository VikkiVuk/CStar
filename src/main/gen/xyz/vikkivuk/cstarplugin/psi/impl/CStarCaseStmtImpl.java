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

public class CStarCaseStmtImpl extends ASTWrapperPsiElement implements CStarCaseStmt {

  public CStarCaseStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CStarVisitor visitor) {
    visitor.visitCaseStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CStarVisitor) accept((CStarVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CStarCaseBranch> getCaseBranchList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CStarCaseBranch.class);
  }

  @Override
  @NotNull
  public CStarExpr getExpr() {
    return findNotNullChildByClass(CStarExpr.class);
  }

}
