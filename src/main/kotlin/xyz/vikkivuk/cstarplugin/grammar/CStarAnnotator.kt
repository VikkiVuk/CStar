package xyz.vikkivuk.cstarplugin.grammar

import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.psi.util.siblings
import com.jetbrains.performancePlugin.commands.goToElement
import xyz.vikkivuk.cstarplugin.CStarTypedElement
import xyz.vikkivuk.cstarplugin.psi.CStarFunctionCall
import xyz.vikkivuk.cstarplugin.psi.CStarFunctionDeclaration
import xyz.vikkivuk.cstarplugin.psi.CStarFunctionVariableDeclaration
import xyz.vikkivuk.cstarplugin.psi.CStarParameterList
import xyz.vikkivuk.cstarplugin.psi.CStarTypes
import xyz.vikkivuk.cstarplugin.psi.CStarVariableDeclaration

class CStarAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is PsiErrorElement) {
//            holder.newAnnotation(HighlightSeverity.ERROR, element.errorDescription)
//                .range(element.textRange)
//                .create()

            val errorDescription = element.errorDescription
            if (errorDescription.contains("end expected")) {
                holder.newAnnotation(HighlightSeverity.ERROR, "End statement expected")
                    .range(element.textRange)
                    .highlightType(ProblemHighlightType.ERROR)
                    .create()
            }
        }

        if (element.text == "print") {
            holder.newAnnotation(HighlightSeverity.WARNING, "Print statements are discouraged, and should only be used for debugging purposes.")
                .range(element.textRange)
                .highlightType(ProblemHighlightType.WARNING)
                .create()
        }

        if (element.elementType == CStarTypes.FUNCTION_CALL) {
            holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                .range(element.firstChild.textRange)
                .textAttributes(TextAttributesKey.createTextAttributesKey("FUNCTION_CALL", DefaultLanguageHighlighterColors.CONSTANT))
                .create()
        }

        if (element.elementType == CStarTypes.IDENTIFIER) {
            val reference = element.text
            if (element.parent.reference?.resolve() == null && !(element.parent.elementType == CStarTypes.FUNCTION_VARIABLE_DECLARATION || element.parent.elementType == CStarTypes.FUNCTION_CALL || element.parent.elementType == CStarTypes.VARIABLE_DECLARATION || element.parent.elementType == CStarTypes.MARCH_STMT || element.parent.elementType == CStarTypes.EACH_STMT)) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved reference: $reference")
                    .range(TextRange(element.textRange.startOffset, element.textRange.endOffset))
                    .highlightType(ProblemHighlightType.ERROR)
                    .create()
                return
            } else {
                if (element.parent.reference?.resolve().elementType == CStarTypes.VARIABLE_DECLARATION) {
                    val variableDeclaration = element.parent.reference?.resolve() as CStarVariableDeclaration
                    val variableType = variableDeclaration.type
                    val variableValue = variableDeclaration.identifier.text

                    println("Variable type: $variableType")
                    println("Variable name: $variableValue")
                }
            }

            // TODO: We also need to do type checking here
        }

        if (element is CStarFunctionCall) {
            val functionVariableDeclaration = element.functionReference.reference?.resolve() as? CStarFunctionVariableDeclaration ?: return
            val functionDeclaration = functionVariableDeclaration.parent as CStarFunctionDeclaration
            val functionCallArguments = functionDeclaration.parameterList as CStarParameterList
            val functionCallArgumentsCount = functionCallArguments.children.size
            val functionCallArgumentsPassed = element.exprList?.children?.size ?: 0

            if (functionCallArgumentsCount != functionCallArgumentsPassed) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Function call arguments mismatch: expected $functionCallArgumentsCount, got $functionCallArgumentsPassed")
                    .range(TextRange(element.textRange.startOffset, element.textRange.endOffset))
                    .highlightType(ProblemHighlightType.ERROR)
                    .create()
            }
        }

        // check when indentation ends and if theres not an end statement give a warning that theres possibly a missing end statement
        if (element.elementType == CStarTypes.INDENT) {
            val indentation = element.text
            val parent = element.parent
            val siblings = parent.siblings().toList()
            val indentationIndex = siblings.indexOf(element)
            val nextElement = siblings.getOrNull(indentationIndex + 1)

            if (nextElement == null) {
                holder.newAnnotation(HighlightSeverity.WARNING, "Possibly missing end statement")
                    .range(TextRange(element.textRange.startOffset, element.textRange.endOffset))
                    .highlightType(ProblemHighlightType.WARNING)
                    .create()
            }
        }
    }

}