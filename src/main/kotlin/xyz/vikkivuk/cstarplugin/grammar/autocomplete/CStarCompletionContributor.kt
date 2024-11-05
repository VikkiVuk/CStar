package xyz.vikkivuk.cstarplugin.grammar.autocomplete

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.StandardPatterns.or
import com.intellij.util.ProcessingContext
import xyz.vikkivuk.cstarplugin.CStarLanguage
import xyz.vikkivuk.cstarplugin.file.CStarFile
import xyz.vikkivuk.cstarplugin.psi.CStarBlock
import xyz.vikkivuk.cstarplugin.psi.CStarEachStmt
import xyz.vikkivuk.cstarplugin.psi.CStarFunctionDeclaration
import xyz.vikkivuk.cstarplugin.psi.CStarFunctionVariableDeclaration
import xyz.vikkivuk.cstarplugin.psi.CStarMarchStmt
import xyz.vikkivuk.cstarplugin.psi.CStarVariableDeclaration

class CStarCompletionContributor : CompletionContributor() {
    init {
        extend(CompletionType.BASIC, psiElement(), object : CompletionProvider<CompletionParameters>() {
            override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
                extend(
                    CompletionType.BASIC,
                    psiElement().withLanguage(CStarLanguage),
                    KeywordCompletionProvider()
                )

                // Suggest variables in expressions
                extend(
                    CompletionType.BASIC,
                    psiElement().withLanguage(CStarLanguage),
                    VariableCompletionProvider()
                )
            }
        })
    }
}