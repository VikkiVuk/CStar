// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CStarSupposeStmt extends PsiElement {

  @NotNull
  List<CStarBlock> getBlockList();

  @Nullable
  CStarStatement getStatement();

  @NotNull
  List<CStarTruthExpr> getTruthExprList();

}
