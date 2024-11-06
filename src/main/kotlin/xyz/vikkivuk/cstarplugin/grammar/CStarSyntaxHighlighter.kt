package xyz.vikkivuk.cstarplugin.grammar

import com.intellij.ide.highlighter.EmbeddedTokenHighlighter
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.psi.TokenType
import com.intellij.util.containers.MultiMap
import xyz.vikkivuk.cstarplugin.psi.CStarTypes

class CStarSyntaxHighlighter : SyntaxHighlighterBase(), EmbeddedTokenHighlighter {
    override fun getHighlightingLexer(): Lexer {
        return CStarLexerAdapter() // Ensure CStarLexerAdapter is set up correctly
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            CStarTypes.AND -> arrayOf(KEYWORD)
            CStarTypes.BUMPINGTHAT -> arrayOf(KEYWORD)
            CStarTypes.CASE -> arrayOf(KEYWORD)
            CStarTypes.EACH -> arrayOf(KEYWORD)
            CStarTypes.END -> arrayOf(KEYWORD)
            CStarTypes.FREE -> arrayOf(KEYWORD)
            CStarTypes.FROM -> arrayOf(KEYWORD)
            CStarTypes.IN -> arrayOf(KEYWORD)
            CStarTypes.LIST -> arrayOf(KEYWORD)
            CStarTypes.LITERAL -> arrayOf(KEYWORD)
            CStarTypes.LOCK -> arrayOf(KEYWORD)
            CStarTypes.MARCH -> arrayOf(KEYWORD)
            CStarTypes.NONE -> arrayOf(KEYWORD)
            CStarTypes.NUM -> arrayOf(KEYWORD)
            CStarTypes.PERHAPS -> arrayOf(KEYWORD)
            CStarTypes.SELECT -> arrayOf(KEYWORD)
            CStarTypes.SEND -> arrayOf(KEYWORD)
            CStarTypes.SUPPOSE -> arrayOf(KEYWORD)
            CStarTypes.TASK -> arrayOf(KEYWORD)
            CStarTypes.TO -> arrayOf(KEYWORD)
            CStarTypes.TRUTH -> arrayOf(KEYWORD)
            CStarTypes.WHILST -> arrayOf(KEYWORD)
            CStarTypes.WITH -> arrayOf(KEYWORD)
            CStarTypes.PRINT -> arrayOf(FUNCTION_KEYWORDS)
            CStarTypes.ATTEMPT -> arrayOf(KEYWORD)
            CStarTypes.OOPSIE -> arrayOf(KEYWORD)
            CStarTypes.KILL -> arrayOf(KEYWORD)
            CStarTypes.NEXT -> arrayOf(KEYWORD)
            CStarTypes.OR -> arrayOf(KEYWORD)
            CStarTypes.ASK -> arrayOf(KEYWORD)

            CStarTypes.YES -> arrayOf(BOOLEAN_KEYWORDS)
            CStarTypes.NO -> arrayOf(BOOLEAN_KEYWORDS)

            CStarTypes.ARROW -> arrayOf(SPECIAL)

            CStarTypes.MULT -> arrayOf(SYMBOL)
            CStarTypes.ASSIGN_OP -> arrayOf(SPECIAL)
            CStarTypes.LBRACKET -> arrayOf(SYMBOL)
            CStarTypes.RBRACKET -> arrayOf(SYMBOL)
            CStarTypes.COMMA -> arrayOf(SYMBOL)
            CStarTypes.LPAREN -> arrayOf(SYMBOL)
            CStarTypes.RPAREN -> arrayOf(SYMBOL)
            CStarTypes.EQ -> arrayOf(SPECIAL)
            CStarTypes.NEQ -> arrayOf(SPECIAL)
            CStarTypes.LT -> arrayOf(SPECIAL)
            CStarTypes.LTE -> arrayOf(SPECIAL)
            CStarTypes.GT -> arrayOf(SPECIAL)
            CStarTypes.GTE -> arrayOf(SPECIAL)

            CStarTypes.STRING -> arrayOf(STRING)
            CStarTypes.NUMBER -> arrayOf(NUMBER)
            CStarTypes.IDENTIFIER -> arrayOf(IDENTIFIER)

            CStarTypes.COMMENT -> arrayOf(COMMENT)
            TokenType.BAD_CHARACTER -> arrayOf(DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE)

            else -> emptyArray()
        }
    }

    override fun getEmbeddedTokenAttributes(): MultiMap<IElementType, TextAttributesKey> {
        val map = MultiMap<IElementType, TextAttributesKey>()
        map.putValue(CStarTypes.AND, KEYWORD)
        map.putValue(CStarTypes.BUMPINGTHAT, KEYWORD)
        map.putValue(CStarTypes.CASE, KEYWORD)
        map.putValue(CStarTypes.EACH, KEYWORD)
        map.putValue(CStarTypes.END, KEYWORD)
        map.putValue(CStarTypes.FREE, KEYWORD)
        map.putValue(CStarTypes.FROM, KEYWORD)
        map.putValue(CStarTypes.IN, KEYWORD)
        map.putValue(CStarTypes.LIST, KEYWORD)
        map.putValue(CStarTypes.LITERAL, KEYWORD)
        map.putValue(CStarTypes.LOCK, KEYWORD)
        map.putValue(CStarTypes.MARCH, KEYWORD)
        map.putValue(CStarTypes.NONE, KEYWORD)
        map.putValue(CStarTypes.NUM, KEYWORD)
        map.putValue(CStarTypes.PERHAPS, KEYWORD)
        map.putValue(CStarTypes.SELECT, KEYWORD)
        map.putValue(CStarTypes.SEND, KEYWORD)
        map.putValue(CStarTypes.SUPPOSE, KEYWORD)
        map.putValue(CStarTypes.TASK, KEYWORD)
        map.putValue(CStarTypes.TO, KEYWORD)
        map.putValue(CStarTypes.TRUTH, KEYWORD)
        map.putValue(CStarTypes.WHILST, KEYWORD)
        map.putValue(CStarTypes.WITH, KEYWORD)
        map.putValue(CStarTypes.PRINT, FUNCTION_KEYWORDS)
        map.putValue(CStarTypes.ATTEMPT, KEYWORD)
        map.putValue(CStarTypes.OOPSIE, KEYWORD)
        map.putValue(CStarTypes.KILL, KEYWORD)
        map.putValue(CStarTypes.NEXT, KEYWORD)

        map.putValue(CStarTypes.YES, BOOLEAN_KEYWORDS)
        map.putValue(CStarTypes.NO, BOOLEAN_KEYWORDS)
        map.putValue(CStarTypes.OOPSIE, BOOLEAN_KEYWORDS)

        map.putValue(CStarTypes.ARROW, SPECIAL)

        map.putValue(CStarTypes.MULT, SYMBOL)
        map.putValue(CStarTypes.ASSIGN_OP, SYMBOL)
        map.putValue(CStarTypes.LBRACKET, SYMBOL)
        map.putValue(CStarTypes.RBRACKET, SYMBOL)
        map.putValue(CStarTypes.COMMA, SYMBOL)
        map.putValue(CStarTypes.LPAREN, SYMBOL)
        map.putValue(CStarTypes.RPAREN, SYMBOL)

        map.putValue(CStarTypes.STRING, STRING)
        map.putValue(CStarTypes.NUMBER, NUMBER)
        map.putValue(CStarTypes.IDENTIFIER, IDENTIFIER)
        map.putValue(CStarTypes.COMMENT, COMMENT)

        return map
    }

    companion object {
        val KEYWORD = createTextAttributesKey("CSTAR_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val BOOLEAN_KEYWORDS = createTextAttributesKey("CSTAR_BOOLEAN_KEYWORDS", DefaultLanguageHighlighterColors.NUMBER)
        val FUNCTION_KEYWORDS = createTextAttributesKey("CSTAR_FUNCTION_KEYWORDS", DefaultLanguageHighlighterColors.CONSTANT)
        val OPERATOR_KEYWORDS = createTextAttributesKey("CSTAR_OPERATOR_KEYWORDS", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val STRING = createTextAttributesKey("CSTAR_STRING", DefaultLanguageHighlighterColors.STRING)
        val NUMBER = createTextAttributesKey("CSTAR_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val IDENTIFIER = createTextAttributesKey("CSTAR_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
        val COMMENT = createTextAttributesKey("CSTAR_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val SYMBOL = createTextAttributesKey("CSTAR_SYMBOL", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val SPECIAL = createTextAttributesKey("CSTAR_SPECIAL", DefaultLanguageHighlighterColors.METADATA)
        val SEMICOLON = createTextAttributesKey("CSTAR_SEMICOLON", DefaultLanguageHighlighterColors.METADATA)
    }
}
