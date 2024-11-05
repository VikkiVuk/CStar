// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CStarCaseStmt extends PsiElement {

  @NotNull
  List<CStarCaseBranch> getCaseBranchList();

  @NotNull
  CStarExpr getExpr();

}
