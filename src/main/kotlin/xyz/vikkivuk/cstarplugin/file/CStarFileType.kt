package xyz.vikkivuk.cstarplugin.file

import com.intellij.openapi.fileTypes.LanguageFileType
import xyz.vikkivuk.cstarplugin.CStarLanguage
import javax.swing.Icon

object CStarFileType : LanguageFileType(CStarLanguage) {
    override fun getName(): String = "CStar File"
    override fun getDescription(): String = "C* language file"
    override fun getDefaultExtension(): String = "star"
    override fun getIcon(): Icon = Icons.CSTAR_FILE_ICON
}