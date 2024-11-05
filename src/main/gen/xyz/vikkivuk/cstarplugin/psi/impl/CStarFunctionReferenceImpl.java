// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static xyz.vikkivuk.cstarplugin.psi.CStarTypes.*;
import xyz.vikkivuk.cstarplugin.CStarVariableReferenceMixin;
import xyz.vikkivuk.cstarplugin.psi.*;

public class CStarFunctionReferenceImpl extends CStarVariableReferenceMixin implements CStarFunctionReference {

  public CStarFunctionReferenceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CStarVisitor visitor) {
    visitor.visitFunctionReference(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CStarVisitor) accept((CStarVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
