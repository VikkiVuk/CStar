package xyz.vikkivuk.cstarplugin.grammar.formatter

import com.intellij.formatting.*
import com.intellij.psi.PsiElement
import com.intellij.psi.codeStyle.CodeStyleSettings
import xyz.vikkivuk.cstarplugin.CStarLanguage
import xyz.vikkivuk.cstarplugin.psi.CStarTypes

class CStarFormattingModelBuilder : FormattingModelBuilder {
    override fun createModel(context: FormattingContext): FormattingModel {
        val element: PsiElement = context.psiElement
        val settings: CodeStyleSettings = context.codeStyleSettings

        return FormattingModelProvider.createFormattingModelForPsiFile(
            element.containingFile,
            CStarBlock(
                element.node,
                Wrap.createWrap(WrapType.NONE, false),
                null, // Remove global alignment
                createSpaceBuilder(settings)
            ),
            settings
        )
    }

    private fun createSpaceBuilder(settings: CodeStyleSettings): SpacingBuilder {
        // TODO: Implement spacing rules
        return SpacingBuilder(settings, CStarLanguage)
    }
}
