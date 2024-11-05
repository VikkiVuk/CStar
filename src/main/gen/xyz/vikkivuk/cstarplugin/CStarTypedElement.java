package xyz.vikkivuk.cstarplugin;

import com.intellij.psi.PsiElement;

public interface CStarTypedElement extends PsiElement {
    CStarType getType();
}
