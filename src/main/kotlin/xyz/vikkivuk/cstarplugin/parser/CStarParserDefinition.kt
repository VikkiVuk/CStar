package xyz.vikkivuk.cstarplugin.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import xyz.vikkivuk.cstarplugin.file.CStarFile
import xyz.vikkivuk.cstarplugin.CStarLanguage
import xyz.vikkivuk.cstarplugin.grammar.CStarLexerAdapter
import xyz.vikkivuk.cstarplugin.psi.CStarTypes

class CStarParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = CStarLexerAdapter()
    override fun createParser(project: Project): PsiParser = CStarParser()
    override fun getFileNodeType(): IFileElementType = FILE
    override fun getCommentTokens(): TokenSet = TokenSet.create(CStarTypes.COMMENT)
    override fun getStringLiteralElements(): TokenSet = TokenSet.create(CStarTypes.STRING)
    override fun createElement(node: ASTNode): PsiElement = CStarTypes.Factory.createElement(node)
    override fun createFile(viewProvider: FileViewProvider): PsiFile = CStarFile(viewProvider)

}

val FILE = IFileElementType(CStarLanguage)