package xyz.vikkivuk.cstarplugin.grammar.formatter

import com.intellij.lang.Language
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider
import xyz.vikkivuk.cstarplugin.CStarLanguage

class CStarLanguageCodeStyleSettingsProvider : LanguageCodeStyleSettingsProvider() {
    override fun getLanguage(): Language = CStarLanguage
    override fun getCodeSample(p0: SettingsType): String? {
        return """
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
    }

    override fun createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings? {
        return CStarCodeStyleSettings(settings)
    }

    override fun getConfigurableDisplayName(): String = "CStar"
}