// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import xyz.vikkivuk.cstarplugin.CStarReferenceElement;
import xyz.vikkivuk.cstarplugin.CStarTypedElement;

public class CStarVisitor extends PsiElementVisitor {

  public void visitAddExpr(@NotNull CStarAddExpr o) {
    visitPsiElement(o);
  }

  public void visitAssignment(@NotNull CStarAssignment o) {
    visitPsiElement(o);
  }

  public void visitBasicPrimary(@NotNull CStarBasicPrimary o) {
    visitPsiElement(o);
  }

  public void visitBlock(@NotNull CStarBlock o) {
    visitPsiElement(o);
  }

  public void visitCaseBranch(@NotNull CStarCaseBranch o) {
    visitPsiElement(o);
  }

  public void visitCaseStmt(@NotNull CStarCaseStmt o) {
    visitPsiElement(o);
  }

  public void visitCatchBlocks(@NotNull CStarCatchBlocks o) {
    visitPsiElement(o);
  }

  public void visitComparisonExpr(@NotNull CStarComparisonExpr o) {
    visitPsiElement(o);
  }

  public void visitComparisonOp(@NotNull CStarComparisonOp o) {
    visitPsiElement(o);
  }

  public void visitConcatExpr(@NotNull CStarConcatExpr o) {
    visitPsiElement(o);
  }

  public void visitControlFlow(@NotNull CStarControlFlow o) {
    visitPsiElement(o);
  }

  public void visitEachStmt(@NotNull CStarEachStmt o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull CStarExpr o) {
    visitTypedElement(o);
  }

  public void visitExprList(@NotNull CStarExprList o) {
    visitPsiElement(o);
  }

  public void visitFunctionCall(@NotNull CStarFunctionCall o) {
    visitReferenceElement(o);
  }

  public void visitFunctionCallStmt(@NotNull CStarFunctionCallStmt o) {
    visitPsiElement(o);
  }

  public void visitFunctionDeclaration(@NotNull CStarFunctionDeclaration o) {
    visitPsiElement(o);
  }

  public void visitFunctionReference(@NotNull CStarFunctionReference o) {
    visitReferenceElement(o);
  }

  public void visitFunctionVariableDeclaration(@NotNull CStarFunctionVariableDeclaration o) {
    visitPsiElement(o);
  }

  public void visitInputStmt(@NotNull CStarInputStmt o) {
    visitPsiElement(o);
  }

  public void visitListLiteral(@NotNull CStarListLiteral o) {
    visitPsiElement(o);
  }

  public void visitMarchStmt(@NotNull CStarMarchStmt o) {
    visitPsiElement(o);
  }

  public void visitMulExpr(@NotNull CStarMulExpr o) {
    visitPsiElement(o);
  }

  public void visitParameter(@NotNull CStarParameter o) {
    visitPsiElement(o);
  }

  public void visitParameterList(@NotNull CStarParameterList o) {
    visitPsiElement(o);
  }

  public void visitPrimary(@NotNull CStarPrimary o) {
    visitPsiElement(o);
  }

  public void visitPrintStmt(@NotNull CStarPrintStmt o) {
    visitPsiElement(o);
  }

  public void visitStatement(@NotNull CStarStatement o) {
    visitPsiElement(o);
  }

  public void visitSupposeStmt(@NotNull CStarSupposeStmt o) {
    visitPsiElement(o);
  }

  public void visitTable(@NotNull CStarTable o) {
    visitPsiElement(o);
  }

  public void visitTabularExprList(@NotNull CStarTabularExprList o) {
    visitPsiElement(o);
  }

  public void visitTruthExpr(@NotNull CStarTruthExpr o) {
    visitPsiElement(o);
  }

  public void visitTryCatchStmt(@NotNull CStarTryCatchStmt o) {
    visitPsiElement(o);
  }

  public void visitType(@NotNull CStarType o) {
    visitPsiElement(o);
  }

  public void visitVariableDeclaration(@NotNull CStarVariableDeclaration o) {
    visitTypedElement(o);
  }

  public void visitVariableModifier(@NotNull CStarVariableModifier o) {
    visitPsiElement(o);
  }

  public void visitVariableReference(@NotNull CStarVariableReference o) {
    visitReferenceElement(o);
  }

  public void visitVariableSet(@NotNull CStarVariableSet o) {
    visitPsiElement(o);
  }

  public void visitWhilstStmt(@NotNull CStarWhilstStmt o) {
    visitPsiElement(o);
  }

  public void visitReferenceElement(@NotNull CStarReferenceElement o) {
    visitPsiElement(o);
  }

  public void visitTypedElement(@NotNull CStarTypedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
