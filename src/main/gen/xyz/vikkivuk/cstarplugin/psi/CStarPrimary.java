// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CStarPrimary extends PsiElement {

  @Nullable
  CStarExpr getExpr();

  @Nullable
  CStarFunctionCall getFunctionCall();

  @Nullable
  CStarListLiteral getListLiteral();

  @Nullable
  CStarTable getTable();

  @Nullable
  CStarVariableReference getVariableReference();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getString();

}
