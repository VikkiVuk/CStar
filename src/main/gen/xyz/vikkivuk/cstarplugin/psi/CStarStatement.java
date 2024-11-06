// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CStarStatement extends PsiElement {

  @Nullable
  CStarAssignment getAssignment();

  @Nullable
  CStarControlFlow getControlFlow();

  @Nullable
  CStarFunctionCallStmt getFunctionCallStmt();

  @Nullable
  CStarFunctionDeclaration getFunctionDeclaration();

  @Nullable
  CStarInputStmt getInputStmt();

  @Nullable
  CStarPrintStmt getPrintStmt();

  @Nullable
  CStarVariableSet getVariableSet();

}
