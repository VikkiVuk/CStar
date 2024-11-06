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
import xyz.vikkivuk.cstarplugin.CStarType
import xyz.vikkivuk.cstarplugin.CStarTypedElement
import xyz.vikkivuk.cstarplugin.psi.*

class CStarAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        /* Make sure the error messages are readable */
        if (element is PsiErrorElement) {
            val errorDescription = element.errorDescription
            if (errorDescription.contains("end expected")) {
                holder.newAnnotation(HighlightSeverity.ERROR, "End statement expected")
                    .range(element.textRange)
                    .highlightType(ProblemHighlightType.ERROR)
                    .create()
            }
        }

        /* Annotate that prints are discouraged */
        if (element.text == "print") {
            holder.newAnnotation(HighlightSeverity.WARNING, "Print statements are discouraged, and should only be used for debugging purposes.")
                .range(element.textRange)
                .highlightType(ProblemHighlightType.WARNING)
                .create()
        }

        /* Check that the variable is declared */
        if (element.elementType == CStarTypes.IDENTIFIER) {
            val reference = element.text
            if (element.parent.reference?.resolve() == null && !(element.parent.elementType == CStarTypes.FUNCTION_VARIABLE_DECLARATION || element.parent.elementType == CStarTypes.FUNCTION_CALL || element.parent.elementType == CStarTypes.VARIABLE_DECLARATION || element.parent.elementType == CStarTypes.MARCH_STMT || element.parent.elementType == CStarTypes.EACH_STMT)) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved reference: $reference")
                    .range(TextRange(element.textRange.startOffset, element.textRange.endOffset))
                    .highlightType(ProblemHighlightType.ERROR)
                    .create()
                return
            }
        }

        /* Check that the variable type matches the required type and that the amount of parameters passed to a function call is correct */
        if (element.elementType == CStarTypes.FUNCTION_CALL) {
            val functionCall = element as CStarFunctionCall
            val functionVariableDeclaration = functionCall.functionReference.reference?.resolve() as? CStarFunctionVariableDeclaration ?: return
            val functionDeclaration = functionVariableDeclaration.parent as CStarFunctionDeclaration
            val functionCallArguments = functionDeclaration.parameterList as CStarParameterList

            val functionCallArgumentsCount = functionCallArguments.children.size
            val functionCallArgumentsPassed = element.exprList?.children?.size ?: 0

            if (functionCallArgumentsCount != functionCallArgumentsPassed) {
                holder.newAnnotation(HighlightSeverity.ERROR, "Function call arguments mismatch: expected $functionCallArgumentsCount, got $functionCallArgumentsPassed")
                    .range(TextRange(element.textRange.startOffset, element.textRange.endOffset))
                    .highlightType(ProblemHighlightType.ERROR)
                    .create()
                return
            }

            holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                .range(element.firstChild.textRange)
                .textAttributes(TextAttributesKey.createTextAttributesKey("FUNCTION_CALL", DefaultLanguageHighlighterColors.CONSTANT))
                .create()

            element.exprList?.children?.forEach {
                if (it is CStarExpr) {
                    val itIndex = functionCall.exprList?.children?.indexOf(it)
                    val parameterType = it.type as CStarType
                    val fParam = functionCallArguments.children.get(itIndex!!) as CStarParameter
                    var fParamType = CStarType.NONE

                    when (fParam.type?.text) {
                        "num" -> fParamType = CStarType.NUM
                        "literal" -> fParamType = CStarType.LITERAL
                        "truth" -> fParamType = CStarType.TRUTH
                        "list" -> fParamType = CStarType.LIST
                        "table" -> fParamType = CStarType.TABLE
                        "none" -> fParamType = CStarType.NONE
                    }

                    if (parameterType != fParamType && fParamType != CStarType.NONE) {
                        println("Function call argument type mismatch: expected $fParamType, got $parameterType")
                        holder.newAnnotation(HighlightSeverity.ERROR, "Function call argument type mismatch: expected $fParamType, got $parameterType")
                            .range(it.textRange)
                            .highlightType(ProblemHighlightType.ERROR)
                            .create()
                    }
                }
            }
        }
    }
}