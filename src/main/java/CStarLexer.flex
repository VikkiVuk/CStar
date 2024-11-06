/* Import necessary IntelliJ packages */
import com.intellij.psi.tree.IElementType;
import xyz.vikkivuk.cstarplugin.psi.CStarTypes;
import com.intellij.psi.TokenType;
import com.intellij.lexer.FlexLexer;
%%

/* Set the class name and package */
%public
%class CStarLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

/* Define tokens */
%%

/* Literals */
\"([^\"\n]|\.)*\"            { return CStarTypes.STRING; }  // String literal
\'([^\'\n]|\.)*\'            { return CStarTypes.STRING; }  // String literal
[0-9]+                       { return CStarTypes.NUMBER; }  // Numbers

/* Keywords */
"and"                        { return CStarTypes.AND; }
"bumpingThat"                { return CStarTypes.BUMPINGTHAT; }
"when"                       { return CStarTypes.CASE; }
"each"                       { return CStarTypes.EACH; }
"end"                        { return CStarTypes.END; }
"free"                       { return CStarTypes.FREE; }
"from"                       { return CStarTypes.FROM; }
"in"                         { return CStarTypes.IN; }
"list"                       { return CStarTypes.LIST; }
"literal"                    { return CStarTypes.LITERAL; }
"lock"                       { return CStarTypes.LOCK; }
"march"                      { return CStarTypes.MARCH; }
"none"                       { return CStarTypes.NONE; }
"num"                        { return CStarTypes.NUM; }
"perhaps"                    { return CStarTypes.PERHAPS; }
"select"                     { return CStarTypes.SELECT; }
"send"                       { return CStarTypes.SEND; }
"suppose"                    { return CStarTypes.SUPPOSE; }
"task"                       { return CStarTypes.TASK; }
"to"                         { return CStarTypes.TO; }
"truth"                      { return CStarTypes.TRUTH; }
"whilst"                     { return CStarTypes.WHILST; }
"with"                       { return CStarTypes.WITH; }
"print"                      { return CStarTypes.PRINT; }
"attempt"                    { return CStarTypes.ATTEMPT; }
"oopsie"                     { return CStarTypes.OOPSIE; }
"kill"                       { return CStarTypes.KILL; }
"next"                       { return CStarTypes.NEXT; }
"or"                         { return CStarTypes.OR; }
"ask"                        { return CStarTypes.ASK; }

/*olean keywords */
"yes"                        { return CStarTypes.YES; }
"no"                         { return CStarTypes.NO; }
"oopsie"                     { return CStarTypes.OOPSIE; }

/* Special */
"=>"                         { return CStarTypes.ARROW; }
";"                          { return TokenType.BAD_CHARACTER; }

/* Additional Symbols */
"*"                          { return CStarTypes.MULT; }
"="                          { return CStarTypes.ASSIGN_OP; }
"=="                         { return CStarTypes.EQ; }
"!="                         { return CStarTypes.NEQ; }
"<"                          { return CStarTypes.LT; }
"<="                         { return CStarTypes.LTE; }
">"                          { return CStarTypes.GT; }
">="                         { return CStarTypes.GTE; }
"["                          { return CStarTypes.LBRACKET; }
"]"                          { return CStarTypes.RBRACKET; }
","                          { return CStarTypes.COMMA; }
"("                          { return CStarTypes.LPAREN; }
")"                          { return CStarTypes.RPAREN; }
"+"                          { return CStarTypes.PLUS; }
"-"                          { return CStarTypes.MINUS; }
"/"                          { return CStarTypes.DIV; }
"}"                          { return CStarTypes.RBRACE; }
"{"                          { return CStarTypes.LBRACE; }

/* Identifiers */
[a-zA-Z_][a-zA-Z0-9_]*       { return CStarTypes.IDENTIFIER; } // Identifiers (e.g., variable names)

/* Whitespace */
[ \r\n]+                     { return TokenType.WHITE_SPACE; }
/* Indentation */
[ \t]+                       { return CStarTypes.INDENT; }

/* Comments */
"#"[^\n]*                    { return CStarTypes.COMMENT; }
"\(\*"[^\*]*"\*\)"           { return CStarTypes.COMMENT; }
"!"[^\n]*                    { return CStarTypes.COMMENT; }
"//"[^\n]*                   { return CStarTypes.COMMENT; }
"\/\*"[^\*]*"\*\/"           { return CStarTypes.COMMENT; }

/* Newline */
(\r?\n)+                     { return CStarTypes.NEWLINE; }

/* Catch-all for unrecognized input */
.                            { System.out.println("Unknown input: " + yytext()); return TokenType.BAD_CHARACTER; }