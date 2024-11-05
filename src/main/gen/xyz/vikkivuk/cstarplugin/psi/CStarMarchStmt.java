// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CStarMarchStmt extends PsiElement {

  @NotNull
  CStarBlock getBlock();

  @NotNull
  CStarVariableDeclaration getVariableDeclaration();

  @NotNull
  List<CStarVariableReference> getVariableReferenceList();

}
