package xyz.vikkivuk.cstarplugin;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;

public abstract class CStarVariableReferenceMixin extends ASTWrapperPsiElement implements CStarReferenceElement {
    public CStarVariableReferenceMixin(ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference getReference() {
        return new CStarVariablePSIReference(this);
    }
}