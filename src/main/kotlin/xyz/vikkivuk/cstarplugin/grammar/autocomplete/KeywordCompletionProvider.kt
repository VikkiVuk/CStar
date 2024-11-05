package xyz.vikkivuk.cstarplugin.grammar.autocomplete

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext
import xyz.vikkivuk.cstarplugin.file.CStarFile
import xyz.vikkivuk.cstarplugin.psi.CStarBlock

class KeywordCompletionProvider : CompletionProvider<CompletionParameters>() {
    private val keywords = listOf(
        "free", "lock", "task", "whilst", "print", "attempt",
        "suppose", "bumpingThat", "case", "each", "march", "end"
    )

    private val blockSpecificKeywords = listOf(
        "from", "in", "list", "literal", "none", "num", "truth", "with", "send", "select", "oopsie", "kill", "next"
    )

    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val position = parameters.position
        val parent = position.parent

        // Check if we're at the start of a new statement
        if (parent.parent is CStarFile) {
            for (keyword in keywords) {
                result.addElement(LookupElementBuilder.create(keyword))
            }
        } else if (parent is CStarBlock) {
            for (keyword in blockSpecificKeywords) {
                result.addElement(LookupElementBuilder.create(keyword))
            }
        }
    }
}