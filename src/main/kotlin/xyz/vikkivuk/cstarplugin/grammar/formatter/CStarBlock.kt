package xyz.vikkivuk.cstarplugin.grammar.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.TokenType
import xyz.vikkivuk.cstarplugin.psi.CStarTypes

class CStarBlock(
    private val node: ASTNode,
    private val wrap: Wrap?,
    private val alignment: Alignment?,
    private val spacingBuilder: SpacingBuilder
) : ASTBlock {

    override fun getNode(): ASTNode = node
    override fun getAlignment(): Alignment? = alignment
    override fun getWrap(): Wrap? = wrap

    override fun getIndent(): Indent? {
        return when (node.elementType) {
            CStarTypes.SUPPOSE,
            CStarTypes.WHILST,
            CStarTypes.EACH,
            CStarTypes.MARCH,
            CStarTypes.ATTEMPT,
            CStarTypes.ARROW,
            CStarTypes.TASK -> Indent.getNormalIndent() // Indent control flow statements and tasks
            CStarTypes.END -> Indent.getNoneIndent() // No indent for 'end' keyword
            else -> Indent.getNoneIndent() // No indent for other nodes
        }
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingBuilder.getSpacing(this, child1, child2)
    }

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        return ChildAttributes(Indent.getNoneIndent(), null) // No default indent for new children
    }

    override fun isIncomplete(): Boolean = false
    override fun isLeaf(): Boolean = node.firstChildNode == null
    override fun getTextRange(): TextRange {
        return node.textRange
    }

    override fun getSubBlocks(): List<Block> {
        val blocks = mutableListOf<Block>()
        var child = node.firstChildNode
        while (child != null) {
            if (child.textRange.length > 0 && !isWhitespaceOrComment(child)) {
                val alignment = if (isAlignedBlock(child)) Alignment.createAlignment() else null
                blocks.add(
                    CStarBlock(
                        child,
                        null, // Let the formatter handle wrapping
                        alignment,
                        spacingBuilder
                    )
                )
            }
            child = child.treeNext
        }
        return blocks
    }

    private fun isWhitespaceOrComment(node: ASTNode): Boolean {
        return node.elementType == TokenType.WHITE_SPACE || node.elementType == CStarTypes.COMMENT
    }

    private fun isAlignedBlock(node: ASTNode): Boolean {
        return when (node.elementType) {
            CStarTypes.PARAMETER_LIST,
            CStarTypes.CASE_BRANCH -> true
            else -> false
        }
    }
}
