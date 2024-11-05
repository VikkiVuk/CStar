package xyz.vikkivuk.cstarplugin.grammar.autocomplete

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.util.ProcessingContext
import xyz.vikkivuk.cstarplugin.psi.CStarFunctionVariableDeclaration
import xyz.vikkivuk.cstarplugin.psi.CStarTypes
import xyz.vikkivuk.cstarplugin.psi.CStarVariableDeclaration

class VariableCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val position = parameters.position
        val variablesInScope = collectVariablesInScope(position)

        for (variable in variablesInScope) {
            result.addElement(LookupElementBuilder.create(variable))
        }
    }

    private fun collectVariablesInScope(position: PsiElement): Set<String> {
        val variables = mutableSetOf<String>()
        val scopeElement = position.containingFile

        val variableDeclarations = PsiTreeUtil.findChildrenOfType(scopeElement, PsiElement::class.java).filterIsInstance<CStarVariableDeclaration>()
        for (declaration in variableDeclarations) {
            println(declaration.identifier.reference?.resolve())
            val parentType = declaration.identifier.parent.elementType
            if (parentType != CStarTypes.MARCH_STMT && parentType != CStarTypes.EACH_STMT) {
                variables.add(declaration.identifier.text)
            }
        }

        val functionVariables = PsiTreeUtil.findChildrenOfType(scopeElement, PsiElement::class.java).filterIsInstance<CStarFunctionVariableDeclaration>()
        for (declaration in functionVariables) {
            variables.add(declaration.identifier.text)
        }

        return variables
    }
}