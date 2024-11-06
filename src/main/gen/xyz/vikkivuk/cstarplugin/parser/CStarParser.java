// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static xyz.vikkivuk.cstarplugin.psi.CStarTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class CStarParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return starFile(b, l + 1);
  }

  /* ********************************************************** */
  // mulExpr ((PLUS | MINUS) mulExpr)*
  public static boolean addExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADD_EXPR, "<add expr>");
    r = mulExpr(b, l + 1);
    r = r && addExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((PLUS | MINUS) mulExpr)*
  private static boolean addExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!addExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "addExpr_1", c)) break;
    }
    return true;
  }

  // (PLUS | MINUS) mulExpr
  private static boolean addExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = addExpr_1_0_0(b, l + 1);
    r = r && mulExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PLUS | MINUS
  private static boolean addExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  /* ********************************************************** */
  // variableModifier variableDeclaration ASSIGN_OP expr
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, "<assignment>", FREE, LOCK)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = variableModifier(b, l + 1);
    r = r && variableDeclaration(b, l + 1);
    r = r && consumeToken(b, ASSIGN_OP);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING
  //                 | NUMBER
  //                 | IDENTIFIER
  public static boolean basicPrimary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "basicPrimary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASIC_PRIMARY, "<basic primary>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (statement NEWLINE?)+
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, "<block>");
    r = block_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!block_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // statement NEWLINE?
  private static boolean block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    r = r && block_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NEWLINE?
  private static boolean block_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // CASE expr ARROW block
  public static boolean caseBranch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranch")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && block(b, l + 1);
    exit_section_(b, m, CASE_BRANCH, r);
    return r;
  }

  /* ********************************************************** */
  // SELECT expr ARROW caseBranch+ END
  public static boolean caseStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseStmt")) return false;
    if (!nextTokenIs(b, SELECT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SELECT);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && caseStmt_3(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, CASE_STMT, r);
    return r;
  }

  // caseBranch+
  private static boolean caseStmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseStmt_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = caseBranch(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!caseBranch(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseStmt_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OOPSIE ARROW block
  public static boolean catchBlocks(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catchBlocks")) return false;
    if (!nextTokenIs(b, OOPSIE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OOPSIE, ARROW);
    r = r && block(b, l + 1);
    exit_section_(b, m, CATCH_BLOCKS, r);
    return r;
  }

  /* ********************************************************** */
  // expr (comparisonOp expr)*
  public static boolean comparisonExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARISON_EXPR, "<comparison expr>");
    r = expr(b, l + 1);
    r = r && comparisonExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (comparisonOp expr)*
  private static boolean comparisonExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comparisonExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "comparisonExpr_1", c)) break;
    }
    return true;
  }

  // comparisonOp expr
  private static boolean comparisonExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comparisonOp(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EQ | NEQ | GT | LT | GTE | LTE
  public static boolean comparisonOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARISON_OP, "<comparison op>");
    r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NEQ);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, GTE);
    if (!r) r = consumeToken(b, LTE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // addExpr (AND addExpr)*
  public static boolean concatExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concatExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONCAT_EXPR, "<concat expr>");
    r = addExpr(b, l + 1);
    r = r && concatExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (AND addExpr)*
  private static boolean concatExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concatExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!concatExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "concatExpr_1", c)) break;
    }
    return true;
  }

  // AND addExpr
  private static boolean concatExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concatExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && addExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // supposeStmt | whilstStmt | caseStmt | eachStmt | marchStmt | tryCatchStmt
  public static boolean controlFlow(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "controlFlow")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTROL_FLOW, "<control flow>");
    r = supposeStmt(b, l + 1);
    if (!r) r = whilstStmt(b, l + 1);
    if (!r) r = caseStmt(b, l + 1);
    if (!r) r = eachStmt(b, l + 1);
    if (!r) r = marchStmt(b, l + 1);
    if (!r) r = tryCatchStmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EACH variableDeclaration IN (listLiteral | table | variableReference[list]) ARROW block END
  public static boolean eachStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eachStmt")) return false;
    if (!nextTokenIs(b, EACH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EACH);
    r = r && variableDeclaration(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && eachStmt_3(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, EACH_STMT, r);
    return r;
  }

  // listLiteral | table | variableReference[list]
  private static boolean eachStmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eachStmt_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = listLiteral(b, l + 1);
    if (!r) r = table(b, l + 1);
    if (!r) r = eachStmt_3_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // variableReference[list]
  private static boolean eachStmt_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eachStmt_3_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableReference(b, l + 1);
    r = r && eachStmt_3_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [list]
  private static boolean eachStmt_3_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eachStmt_3_2_1")) return false;
    consumeToken(b, LIST);
    return true;
  }

  /* ********************************************************** */
  // concatExpr
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = concatExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expr ((COMMA | AND) expr)*
  public static boolean exprList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR_LIST, "<expr list>");
    r = expr(b, l + 1);
    r = r && exprList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((COMMA | AND) expr)*
  private static boolean exprList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!exprList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "exprList_1", c)) break;
    }
    return true;
  }

  // (COMMA | AND) expr
  private static boolean exprList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = exprList_1_0_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA | AND
  private static boolean exprList_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprList_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, AND);
    return r;
  }

  /* ********************************************************** */
  // functionReference ((LPAREN exprList? RPAREN) | exprList)
  public static boolean functionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionReference(b, l + 1);
    r = r && functionCall_1(b, l + 1);
    exit_section_(b, m, FUNCTION_CALL, r);
    return r;
  }

  // (LPAREN exprList? RPAREN) | exprList
  private static boolean functionCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionCall_1_0(b, l + 1);
    if (!r) r = exprList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN exprList? RPAREN
  private static boolean functionCall_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && functionCall_1_0_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // exprList?
  private static boolean functionCall_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0_1")) return false;
    exprList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // functionCall
  public static boolean functionCallStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCallStmt")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionCall(b, l + 1);
    exit_section_(b, m, FUNCTION_CALL_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // TASK functionVariableDeclaration (WITH parameterList)? ARROW block END
  public static boolean functionDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration")) return false;
    if (!nextTokenIs(b, TASK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DECLARATION, null);
    r = consumeToken(b, TASK);
    p = r; // pin = 1
    r = r && report_error_(b, functionVariableDeclaration(b, l + 1));
    r = p && report_error_(b, functionDeclaration_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, ARROW)) && r;
    r = p && report_error_(b, block(b, l + 1)) && r;
    r = p && consumeToken(b, END) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (WITH parameterList)?
  private static boolean functionDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_2")) return false;
    functionDeclaration_2_0(b, l + 1);
    return true;
  }

  // WITH parameterList
  private static boolean functionDeclaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WITH);
    r = r && parameterList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean functionReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionReference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FUNCTION_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean functionVariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionVariableDeclaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FUNCTION_VARIABLE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // ASK ((LPAREN expr RPAREN) | expr)
  public static boolean inputStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inputStmt")) return false;
    if (!nextTokenIs(b, ASK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASK);
    r = r && inputStmt_1(b, l + 1);
    exit_section_(b, m, INPUT_STMT, r);
    return r;
  }

  // (LPAREN expr RPAREN) | expr
  private static boolean inputStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inputStmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inputStmt_1_0(b, l + 1);
    if (!r) r = expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN expr RPAREN
  private static boolean inputStmt_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inputStmt_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET exprList? RBRACKET
  public static boolean listLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteral")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && listLiteral_1(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, LIST_LITERAL, r);
    return r;
  }

  // exprList?
  private static boolean listLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listLiteral_1")) return false;
    exprList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MARCH variableDeclaration FROM (NUMBER | variableReference[num]) TO (NUMBER | variableReference[num]) ARROW block END
  public static boolean marchStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "marchStmt")) return false;
    if (!nextTokenIs(b, MARCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MARCH);
    r = r && variableDeclaration(b, l + 1);
    r = r && consumeToken(b, FROM);
    r = r && marchStmt_3(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && marchStmt_5(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, MARCH_STMT, r);
    return r;
  }

  // NUMBER | variableReference[num]
  private static boolean marchStmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "marchStmt_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    if (!r) r = marchStmt_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // variableReference[num]
  private static boolean marchStmt_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "marchStmt_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableReference(b, l + 1);
    r = r && marchStmt_3_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [num]
  private static boolean marchStmt_3_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "marchStmt_3_1_1")) return false;
    consumeToken(b, NUM);
    return true;
  }

  // NUMBER | variableReference[num]
  private static boolean marchStmt_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "marchStmt_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    if (!r) r = marchStmt_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // variableReference[num]
  private static boolean marchStmt_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "marchStmt_5_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableReference(b, l + 1);
    r = r && marchStmt_5_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [num]
  private static boolean marchStmt_5_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "marchStmt_5_1_1")) return false;
    consumeToken(b, NUM);
    return true;
  }

  /* ********************************************************** */
  // primary ((MULT | DIV) primary)*
  public static boolean mulExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mulExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MUL_EXPR, "<mul expr>");
    r = primary(b, l + 1);
    r = r && mulExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((MULT | DIV) primary)*
  private static boolean mulExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mulExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mulExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mulExpr_1", c)) break;
    }
    return true;
  }

  // (MULT | DIV) primary
  private static boolean mulExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mulExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mulExpr_1_0_0(b, l + 1);
    r = r && primary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MULT | DIV
  private static boolean mulExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mulExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, MULT);
    if (!r) r = consumeToken(b, DIV);
    return r;
  }

  /* ********************************************************** */
  // variableDeclaration | (type LPAREN variableDeclaration RPAREN)
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER, "<parameter>");
    r = variableDeclaration(b, l + 1);
    if (!r) r = parameter_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type LPAREN variableDeclaration RPAREN
  private static boolean parameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && variableDeclaration(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // parameter ((COMMA | AND) parameter)*
  public static boolean parameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_LIST, "<parameter list>");
    r = parameter(b, l + 1);
    r = r && parameterList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((COMMA | AND) parameter)*
  private static boolean parameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameterList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameterList_1", c)) break;
    }
    return true;
  }

  // (COMMA | AND) parameter
  private static boolean parameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameterList_1_0_0(b, l + 1);
    r = r && parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA | AND
  private static boolean parameterList_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterList_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, AND);
    return r;
  }

  /* ********************************************************** */
  // functionCall
  //           | variableReference
  //           | STRING
  //           | NUMBER
  //           | YES
  //           | NO
  //           | NONE
  //           | LPAREN expr RPAREN
  //           | listLiteral
  //           | table
  //           | inputStmt
  public static boolean primary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY, "<primary>");
    r = functionCall(b, l + 1);
    if (!r) r = variableReference(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, YES);
    if (!r) r = consumeToken(b, NO);
    if (!r) r = consumeToken(b, NONE);
    if (!r) r = primary_7(b, l + 1);
    if (!r) r = listLiteral(b, l + 1);
    if (!r) r = table(b, l + 1);
    if (!r) r = inputStmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN expr RPAREN
  private static boolean primary_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PRINT ((LPAREN expr RPAREN) | expr)
  public static boolean printStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "printStmt")) return false;
    if (!nextTokenIs(b, PRINT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PRINT);
    r = r && printStmt_1(b, l + 1);
    exit_section_(b, m, PRINT_STMT, r);
    return r;
  }

  // (LPAREN expr RPAREN) | expr
  private static boolean printStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "printStmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = printStmt_1_0(b, l + 1);
    if (!r) r = expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN expr RPAREN
  private static boolean printStmt_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "printStmt_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // statement*
  static boolean starFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "starFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "starFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // assignment
  //             | controlFlow
  //             | functionDeclaration
  //             | functionCallStmt
  //             | variableSet
  //             | inputStmt
  //             | printStmt
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = assignment(b, l + 1);
    if (!r) r = controlFlow(b, l + 1);
    if (!r) r = functionDeclaration(b, l + 1);
    if (!r) r = functionCallStmt(b, l + 1);
    if (!r) r = variableSet(b, l + 1);
    if (!r) r = inputStmt(b, l + 1);
    if (!r) r = printStmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (SUPPOSE truthExpr ARROW block (PERHAPS truthExpr ARROW block)* (BUMPINGTHAT ARROW block)? END) | (SUPPOSE truthExpr ARROW statement)
  public static boolean supposeStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supposeStmt")) return false;
    if (!nextTokenIs(b, SUPPOSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = supposeStmt_0(b, l + 1);
    if (!r) r = supposeStmt_1(b, l + 1);
    exit_section_(b, m, SUPPOSE_STMT, r);
    return r;
  }

  // SUPPOSE truthExpr ARROW block (PERHAPS truthExpr ARROW block)* (BUMPINGTHAT ARROW block)? END
  private static boolean supposeStmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supposeStmt_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUPPOSE);
    r = r && truthExpr(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && block(b, l + 1);
    r = r && supposeStmt_0_4(b, l + 1);
    r = r && supposeStmt_0_5(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PERHAPS truthExpr ARROW block)*
  private static boolean supposeStmt_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supposeStmt_0_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!supposeStmt_0_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "supposeStmt_0_4", c)) break;
    }
    return true;
  }

  // PERHAPS truthExpr ARROW block
  private static boolean supposeStmt_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supposeStmt_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PERHAPS);
    r = r && truthExpr(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (BUMPINGTHAT ARROW block)?
  private static boolean supposeStmt_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supposeStmt_0_5")) return false;
    supposeStmt_0_5_0(b, l + 1);
    return true;
  }

  // BUMPINGTHAT ARROW block
  private static boolean supposeStmt_0_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supposeStmt_0_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BUMPINGTHAT, ARROW);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SUPPOSE truthExpr ARROW statement
  private static boolean supposeStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "supposeStmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUPPOSE);
    r = r && truthExpr(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE tabularExprList? RBRACE
  public static boolean table(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && table_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, TABLE, r);
    return r;
  }

  // tabularExprList?
  private static boolean table_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_1")) return false;
    tabularExprList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // basicPrimary ASSIGN_OP expr ((COMMA | AND) basicPrimary ASSIGN_OP expr)*
  public static boolean tabularExprList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tabularExprList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TABULAR_EXPR_LIST, "<tabular expr list>");
    r = basicPrimary(b, l + 1);
    r = r && consumeToken(b, ASSIGN_OP);
    r = r && expr(b, l + 1);
    r = r && tabularExprList_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((COMMA | AND) basicPrimary ASSIGN_OP expr)*
  private static boolean tabularExprList_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tabularExprList_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tabularExprList_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tabularExprList_3", c)) break;
    }
    return true;
  }

  // (COMMA | AND) basicPrimary ASSIGN_OP expr
  private static boolean tabularExprList_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tabularExprList_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tabularExprList_3_0_0(b, l + 1);
    r = r && basicPrimary(b, l + 1);
    r = r && consumeToken(b, ASSIGN_OP);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA | AND
  private static boolean tabularExprList_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tabularExprList_3_0_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, AND);
    return r;
  }

  /* ********************************************************** */
  // comparisonExpr ((AND | OR) comparisonExpr)*
  public static boolean truthExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "truthExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRUTH_EXPR, "<truth expr>");
    r = comparisonExpr(b, l + 1);
    r = r && truthExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((AND | OR) comparisonExpr)*
  private static boolean truthExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "truthExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!truthExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "truthExpr_1", c)) break;
    }
    return true;
  }

  // (AND | OR) comparisonExpr
  private static boolean truthExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "truthExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = truthExpr_1_0_0(b, l + 1);
    r = r && comparisonExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // AND | OR
  private static boolean truthExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "truthExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    return r;
  }

  /* ********************************************************** */
  // ATTEMPT ARROW block catchBlocks END
  public static boolean tryCatchStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryCatchStmt")) return false;
    if (!nextTokenIs(b, ATTEMPT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ATTEMPT, ARROW);
    r = r && block(b, l + 1);
    r = r && catchBlocks(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, TRY_CATCH_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // NUM | LITERAL | TRUTH | LIST | TABLE
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = consumeToken(b, NUM);
    if (!r) r = consumeToken(b, LITERAL);
    if (!r) r = consumeToken(b, TRUTH);
    if (!r) r = consumeToken(b, LIST);
    if (!r) r = consumeToken(b, TABLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (type IDENTIFIER) | IDENTIFIER
  public static boolean variableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DECLARATION, "<variable declaration>");
    r = variableDeclaration_0(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type IDENTIFIER
  private static boolean variableDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FREE | LOCK
  public static boolean variableModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableModifier")) return false;
    if (!nextTokenIs(b, "<variable modifier>", FREE, LOCK)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_MODIFIER, "<variable modifier>");
    r = consumeToken(b, FREE);
    if (!r) r = consumeToken(b, LOCK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean variableReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableReference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // variableReference ASSIGN_OP expr
  public static boolean variableSet(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableSet")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableReference(b, l + 1);
    r = r && consumeToken(b, ASSIGN_OP);
    r = r && expr(b, l + 1);
    exit_section_(b, m, VARIABLE_SET, r);
    return r;
  }

  /* ********************************************************** */
  // WHILST truthExpr ARROW block END
  public static boolean whilstStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whilstStmt")) return false;
    if (!nextTokenIs(b, WHILST)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILST);
    r = r && truthExpr(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, WHILST_STMT, r);
    return r;
  }

}
