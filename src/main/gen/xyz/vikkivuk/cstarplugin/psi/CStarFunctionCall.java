// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import xyz.vikkivuk.cstarplugin.CStarReferenceElement;

public interface CStarFunctionCall extends CStarReferenceElement {

  @Nullable
  CStarExprList getExprList();

  @NotNull
  CStarFunctionReference getFunctionReference();

  //WARNING: getReference(...) is skipped
  //matching getReference(CStarFunctionCall, ...)
  //methods are not found in null

}
