package xyz.vikkivuk.cstarplugin.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import xyz.vikkivuk.cstarplugin.CStarLanguage

class CStarFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, CStarLanguage) {
    override fun getFileType() = CStarFileType

    override fun toString(): String = "CStar File"

    override fun getIcon(flags: Int) = Icons.CSTAR_FILE_ICON
}