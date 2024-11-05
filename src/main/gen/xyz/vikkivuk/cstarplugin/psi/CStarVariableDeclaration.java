// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import xyz.vikkivuk.cstarplugin.CStarTypedElement;
import xyz.vikkivuk.cstarplugin.CStarType;

public interface CStarVariableDeclaration extends CStarTypedElement {

  @Nullable
  CStarType getType();

  @NotNull
  PsiElement getIdentifier();

}
