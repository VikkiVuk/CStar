package xyz.vikkivuk.cstarplugin

import com.intellij.lang.Language

object CStarLanguage : Language("CStar") {
    private fun readResolve(): Any = CStarLanguage
    override fun getDisplayName(): String = "C* Language"
}