package xyz.vikkivuk.cstarplugin.grammar

import CStarLexer
import com.intellij.lexer.FlexAdapter

class CStarLexerAdapter : FlexAdapter(CStarLexer(null))