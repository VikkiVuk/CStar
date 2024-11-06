// This is a generated file. Not intended for manual editing.
package xyz.vikkivuk.cstarplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import xyz.vikkivuk.cstarplugin.CStarElementType;
import xyz.vikkivuk.cstarplugin.CStarTokenType;
import xyz.vikkivuk.cstarplugin.psi.impl.*;

public interface CStarTypes {

  IElementType ADD_EXPR = new CStarElementType("ADD_EXPR");
  IElementType ASSIGNMENT = new CStarElementType("ASSIGNMENT");
  IElementType BASIC_PRIMARY = new CStarElementType("BASIC_PRIMARY");
  IElementType BLOCK = new CStarElementType("BLOCK");
  IElementType CASE_BRANCH = new CStarElementType("CASE_BRANCH");
  IElementType CASE_STMT = new CStarElementType("CASE_STMT");
  IElementType CATCH_BLOCKS = new CStarElementType("CATCH_BLOCKS");
  IElementType COMPARISON_EXPR = new CStarElementType("COMPARISON_EXPR");
  IElementType COMPARISON_OP = new CStarElementType("COMPARISON_OP");
  IElementType CONCAT_EXPR = new CStarElementType("CONCAT_EXPR");
  IElementType CONTROL_FLOW = new CStarElementType("CONTROL_FLOW");
  IElementType EACH_STMT = new CStarElementType("EACH_STMT");
  IElementType EXPR = new CStarElementType("EXPR");
  IElementType EXPR_LIST = new CStarElementType("EXPR_LIST");
  IElementType FUNCTION_CALL = new CStarElementType("FUNCTION_CALL");
  IElementType FUNCTION_CALL_STMT = new CStarElementType("FUNCTION_CALL_STMT");
  IElementType FUNCTION_DECLARATION = new CStarElementType("FUNCTION_DECLARATION");
  IElementType FUNCTION_REFERENCE = new CStarElementType("FUNCTION_REFERENCE");
  IElementType FUNCTION_VARIABLE_DECLARATION = new CStarElementType("FUNCTION_VARIABLE_DECLARATION");
  IElementType INPUT_STMT = new CStarElementType("INPUT_STMT");
  IElementType LIST_LITERAL = new CStarElementType("LIST_LITERAL");
  IElementType MARCH_STMT = new CStarElementType("MARCH_STMT");
  IElementType MUL_EXPR = new CStarElementType("MUL_EXPR");
  IElementType PARAMETER = new CStarElementType("PARAMETER");
  IElementType PARAMETER_LIST = new CStarElementType("PARAMETER_LIST");
  IElementType PRIMARY = new CStarElementType("PRIMARY");
  IElementType PRINT_STMT = new CStarElementType("PRINT_STMT");
  IElementType STATEMENT = new CStarElementType("STATEMENT");
  IElementType SUPPOSE_STMT = new CStarElementType("SUPPOSE_STMT");
  IElementType TABLE = new CStarElementType("TABLE");
  IElementType TABULAR_EXPR_LIST = new CStarElementType("TABULAR_EXPR_LIST");
  IElementType TRUTH_EXPR = new CStarElementType("TRUTH_EXPR");
  IElementType TRY_CATCH_STMT = new CStarElementType("TRY_CATCH_STMT");
  IElementType TYPE = new CStarElementType("TYPE");
  IElementType VARIABLE_DECLARATION = new CStarElementType("VARIABLE_DECLARATION");
  IElementType VARIABLE_MODIFIER = new CStarElementType("VARIABLE_MODIFIER");
  IElementType VARIABLE_REFERENCE = new CStarElementType("VARIABLE_REFERENCE");
  IElementType VARIABLE_SET = new CStarElementType("VARIABLE_SET");
  IElementType WHILST_STMT = new CStarElementType("WHILST_STMT");

  IElementType AND = new CStarTokenType("and");
  IElementType ARROW = new CStarTokenType("=>");
  IElementType ASK = new CStarTokenType("ask");
  IElementType ASSIGN_OP = new CStarTokenType("=");
  IElementType ATTEMPT = new CStarTokenType("attempt");
  IElementType BUMPINGTHAT = new CStarTokenType("bumpingThat");
  IElementType CASE = new CStarTokenType("case");
  IElementType COMMA = new CStarTokenType(",");
  IElementType COMMENT = new CStarTokenType("COMMENT");
  IElementType DIV = new CStarTokenType("/");
  IElementType EACH = new CStarTokenType("each");
  IElementType END = new CStarTokenType("end");
  IElementType EQ = new CStarTokenType("EQ");
  IElementType FREE = new CStarTokenType("free");
  IElementType FROM = new CStarTokenType("from");
  IElementType GT = new CStarTokenType("GT");
  IElementType GTE = new CStarTokenType("GTE");
  IElementType IDENTIFIER = new CStarTokenType("IDENTIFIER");
  IElementType IN = new CStarTokenType("in");
  IElementType INDENT = new CStarTokenType("INDENT");
  IElementType KILL = new CStarTokenType("kill");
  IElementType LBRACE = new CStarTokenType("{");
  IElementType LBRACKET = new CStarTokenType("[");
  IElementType LIST = new CStarTokenType("list");
  IElementType LITERAL = new CStarTokenType("literal");
  IElementType LOCK = new CStarTokenType("lock");
  IElementType LPAREN = new CStarTokenType("(");
  IElementType LT = new CStarTokenType("LT");
  IElementType LTE = new CStarTokenType("LTE");
  IElementType MARCH = new CStarTokenType("march");
  IElementType MINUS = new CStarTokenType("-");
  IElementType MULT = new CStarTokenType("*");
  IElementType NEQ = new CStarTokenType("NEQ");
  IElementType NEWLINE = new CStarTokenType("NEWLINE");
  IElementType NEXT = new CStarTokenType("next");
  IElementType NO = new CStarTokenType("no");
  IElementType NONE = new CStarTokenType("none");
  IElementType NUM = new CStarTokenType("num");
  IElementType NUMBER = new CStarTokenType("NUMBER");
  IElementType OOPSIE = new CStarTokenType("oopsie");
  IElementType OR = new CStarTokenType("or");
  IElementType PERHAPS = new CStarTokenType("perhaps");
  IElementType PLUS = new CStarTokenType("+");
  IElementType PRINT = new CStarTokenType("print");
  IElementType RBRACE = new CStarTokenType("}");
  IElementType RBRACKET = new CStarTokenType("]");
  IElementType RPAREN = new CStarTokenType(")");
  IElementType SELECT = new CStarTokenType("select");
  IElementType SEND = new CStarTokenType("send");
  IElementType STRING = new CStarTokenType("STRING");
  IElementType SUPPOSE = new CStarTokenType("suppose");
  IElementType TASK = new CStarTokenType("task");
  IElementType TO = new CStarTokenType("to");
  IElementType TRUTH = new CStarTokenType("truth");
  IElementType WHILST = new CStarTokenType("whilst");
  IElementType WITH = new CStarTokenType("with");
  IElementType YES = new CStarTokenType("yes");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADD_EXPR) {
        return new CStarAddExprImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new CStarAssignmentImpl(node);
      }
      else if (type == BASIC_PRIMARY) {
        return new CStarBasicPrimaryImpl(node);
      }
      else if (type == BLOCK) {
        return new CStarBlockImpl(node);
      }
      else if (type == CASE_BRANCH) {
        return new CStarCaseBranchImpl(node);
      }
      else if (type == CASE_STMT) {
        return new CStarCaseStmtImpl(node);
      }
      else if (type == CATCH_BLOCKS) {
        return new CStarCatchBlocksImpl(node);
      }
      else if (type == COMPARISON_EXPR) {
        return new CStarComparisonExprImpl(node);
      }
      else if (type == COMPARISON_OP) {
        return new CStarComparisonOpImpl(node);
      }
      else if (type == CONCAT_EXPR) {
        return new CStarConcatExprImpl(node);
      }
      else if (type == CONTROL_FLOW) {
        return new CStarControlFlowImpl(node);
      }
      else if (type == EACH_STMT) {
        return new CStarEachStmtImpl(node);
      }
      else if (type == EXPR) {
        return new CStarExprImpl(node);
      }
      else if (type == EXPR_LIST) {
        return new CStarExprListImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new CStarFunctionCallImpl(node);
      }
      else if (type == FUNCTION_CALL_STMT) {
        return new CStarFunctionCallStmtImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new CStarFunctionDeclarationImpl(node);
      }
      else if (type == FUNCTION_REFERENCE) {
        return new CStarFunctionReferenceImpl(node);
      }
      else if (type == FUNCTION_VARIABLE_DECLARATION) {
        return new CStarFunctionVariableDeclarationImpl(node);
      }
      else if (type == INPUT_STMT) {
        return new CStarInputStmtImpl(node);
      }
      else if (type == LIST_LITERAL) {
        return new CStarListLiteralImpl(node);
      }
      else if (type == MARCH_STMT) {
        return new CStarMarchStmtImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new CStarMulExprImpl(node);
      }
      else if (type == PARAMETER) {
        return new CStarParameterImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new CStarParameterListImpl(node);
      }
      else if (type == PRIMARY) {
        return new CStarPrimaryImpl(node);
      }
      else if (type == PRINT_STMT) {
        return new CStarPrintStmtImpl(node);
      }
      else if (type == STATEMENT) {
        return new CStarStatementImpl(node);
      }
      else if (type == SUPPOSE_STMT) {
        return new CStarSupposeStmtImpl(node);
      }
      else if (type == TABLE) {
        return new CStarTableImpl(node);
      }
      else if (type == TABULAR_EXPR_LIST) {
        return new CStarTabularExprListImpl(node);
      }
      else if (type == TRUTH_EXPR) {
        return new CStarTruthExprImpl(node);
      }
      else if (type == TRY_CATCH_STMT) {
        return new CStarTryCatchStmtImpl(node);
      }
      else if (type == TYPE) {
        return new CStarTypeImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new CStarVariableDeclarationImpl(node);
      }
      else if (type == VARIABLE_MODIFIER) {
        return new CStarVariableModifierImpl(node);
      }
      else if (type == VARIABLE_REFERENCE) {
        return new CStarVariableReferenceImpl(node);
      }
      else if (type == VARIABLE_SET) {
        return new CStarVariableSetImpl(node);
      }
      else if (type == WHILST_STMT) {
        return new CStarWhilstStmtImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
