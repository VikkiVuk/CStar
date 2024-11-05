// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static xyz.vikkivuk.cstarplugin.psi.CStarTypes.*;
import xyz.vikkivuk.cstarplugin.CStarExprMixin;
import xyz.vikkivuk.cstarplugin.psi.*;

public class CStarExprImpl extends CStarExprMixin implements CStarExpr {

  public CStarExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CStarVisitor visitor) {
    visitor.visitExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CStarVisitor) accept((CStarVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public CStarConcatExpr getConcatExpr() {
    return findNotNullChildByClass(CStarConcatExpr.class);
  }

}
