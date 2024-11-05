// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CStarEachStmt extends PsiElement {

  @NotNull
  CStarBlock getBlock();

  @Nullable
  CStarListLiteral getListLiteral();

  @Nullable
  CStarTable getTable();

  @NotNull
  CStarVariableDeclaration getVariableDeclaration();

  @Nullable
  CStarVariableReference getVariableReference();

}
