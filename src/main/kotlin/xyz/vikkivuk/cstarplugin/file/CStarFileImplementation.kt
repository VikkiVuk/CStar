package xyz.vikkivuk.cstarplugin.file

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import xyz.vikkivuk.cstarplugin.CStarLanguage
import javax.swing.Icon

class CStarFileImplementation : LanguageFileType(CStarLanguage) {
    override fun getName(): String {
        return "CStar File"
    }

    override fun getDescription(): String {
        return "C* language file"
    }

    override fun getDefaultExtension(): String {
        return "star"
    }

    override fun getIcon(): Icon {
        return Icons.CSTAR_FILE_ICON
    }
}