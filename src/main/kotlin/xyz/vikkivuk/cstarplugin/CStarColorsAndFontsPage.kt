package xyz.vikkivuk.cstarplugin

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import xyz.vikkivuk.cstarplugin.file.CStarFileType
import xyz.vikkivuk.cstarplugin.grammar.*
import javax.swing.Icon

class CStarColorsAndFontsPage : ColorSettingsPage {
    override fun getDisplayName(): String = "C* Language"

    override fun getIcon(): Icon = CStarFileType.icon

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = ATTRS

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getHighlighter(): SyntaxHighlighter = CStarSyntaxHighlighter()

    override fun getDemoText(): String = PREVIEW_TEXT

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> = PREVIEW_TAGS
}

private val ATTRS = arrayOf(
    AttributesDescriptor("Keyword", CStarSyntaxHighlighter.KEYWORD),
    AttributesDescriptor("Boolean", CStarSyntaxHighlighter.BOOLEAN_KEYWORDS),
    AttributesDescriptor("Identifier", CStarSyntaxHighlighter.IDENTIFIER),
    AttributesDescriptor("Operator", CStarSyntaxHighlighter.OPERATOR_KEYWORDS),
    AttributesDescriptor("Function", CStarSyntaxHighlighter.FUNCTION_KEYWORDS),
    AttributesDescriptor("Number", CStarSyntaxHighlighter.NUMBER),
    AttributesDescriptor("String", CStarSyntaxHighlighter.STRING),
    AttributesDescriptor("Comment", CStarSyntaxHighlighter.COMMENT),
    AttributesDescriptor("Symbol", CStarSyntaxHighlighter.SYMBOL),
    AttributesDescriptor("Special", CStarSyntaxHighlighter.SPECIAL),
    AttributesDescriptor("Semicolon", CStarSyntaxHighlighter.SEMICOLON)
)

private val PREVIEW_TAGS = mapOf(
    "KEYWORD" to CStarSyntaxHighlighter.KEYWORD,
    "BOOLEAN" to CStarSyntaxHighlighter.BOOLEAN_KEYWORDS,
    "IDENTIFIER" to CStarSyntaxHighlighter.IDENTIFIER,
    "OPERATOR" to CStarSyntaxHighlighter.OPERATOR_KEYWORDS,
    "FUNCTION" to CStarSyntaxHighlighter.FUNCTION_KEYWORDS,
    "NUMBER" to CStarSyntaxHighlighter.NUMBER,
    "STRING" to CStarSyntaxHighlighter.STRING,
    "COMMENT" to CStarSyntaxHighlighter.COMMENT,
    "SYMBOL" to CStarSyntaxHighlighter.SYMBOL,
    "SPECIAL" to CStarSyntaxHighlighter.SPECIAL,
    "SEMICOLON" to CStarSyntaxHighlighter.SEMICOLON
)

val PREVIEW_TEXT = """
    # This is a comment in C*
    free numbers = [1, 2, 3, 4, 5]
    lock someText = "Hello, world!"
    
    suppose x = 5 =>
        print someText
    end
    
    task myFunction with literal(someText) =>
        each number from numbers =>
            print number
        end
    end
    """.trimIndent()