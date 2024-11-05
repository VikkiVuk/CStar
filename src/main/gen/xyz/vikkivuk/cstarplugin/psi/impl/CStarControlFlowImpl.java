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

public class CStarControlFlowImpl extends ASTWrapperPsiElement implements CStarControlFlow {

  public CStarControlFlowImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CStarVisitor visitor) {
    visitor.visitControlFlow(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CStarVisitor) accept((CStarVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CStarCaseStmt getCaseStmt() {
    return findChildByClass(CStarCaseStmt.class);
  }

  @Override
  @Nullable
  public CStarEachStmt getEachStmt() {
    return findChildByClass(CStarEachStmt.class);
  }

  @Override
  @Nullable
  public CStarMarchStmt getMarchStmt() {
    return findChildByClass(CStarMarchStmt.class);
  }

  @Override
  @Nullable
  public CStarSupposeStmt getSupposeStmt() {
    return findChildByClass(CStarSupposeStmt.class);
  }

  @Override
  @Nullable
  public CStarTryCatchStmt getTryCatchStmt() {
    return findChildByClass(CStarTryCatchStmt.class);
  }

  @Override
  @Nullable
  public CStarWhilstStmt getWhilstStmt() {
    return findChildByClass(CStarWhilstStmt.class);
  }

}
