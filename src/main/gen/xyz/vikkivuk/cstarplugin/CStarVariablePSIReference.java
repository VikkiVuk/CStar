package xyz.vikkivuk.cstarplugin;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import xyz.vikkivuk.cstarplugin.psi.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CStarVariablePSIReference extends PsiReferenceBase<CStarReferenceElement> implements PsiPolyVariantReference {

    public CStarVariablePSIReference(@NotNull CStarReferenceElement  element) {
        super(element, new TextRange(0, element.getTextLength()));
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        List<ResolveResult> results = new ArrayList<>();

        PsiElement element = getElement();
        String name = element.getText();

        // Start from the current element's parent to avoid including the element itself
        PsiElement scope = element.getParent();

        // Limit traversal to the containing file
        PsiFile containingFile = element.getContainingFile();

        while (scope != null && scope != containingFile.getParent()) {
            // Find declarations in the current scope
            for (PsiElement child : scope.getChildren()) {
                if (child instanceof CStarStatement statement) {
                    // Handle variable declarations
                    findVariableDeclarations(statement, name, results);
                    // Handle function declarations
                    findFunctionDeclarations(statement, name, results);
                    // Handle variable declarations in blocks
                    findVariableDeclarationsInBlock(statement, name, results);
                }
            }

            if (!results.isEmpty()) {
                return results.toArray(new ResolveResult[0]);
            }

            scope = getEnclosingScope(scope);
        }

        return results.toArray(new ResolveResult[0]);
    }

    // Helper method to find variable declarations
    private void findVariableDeclarations(PsiElement statement, String name, List<ResolveResult> results) {
        for (PsiElement statementChild : statement.getChildren()) {
            if (statementChild instanceof CStarAssignment declaration) {
                for (PsiElement assignmentChild : declaration.getChildren()) {
                    if (assignmentChild instanceof CStarVariableDeclaration variableDeclaration) {
                        String variableName = variableDeclaration.getIdentifier().getText();
                        if (variableName.equals(name)) {
                            results.add(new PsiElementResolveResult(variableDeclaration));
                        }
                    }
                }
            }
        }
    }

    // Helper method to find function declarations
    private void findFunctionDeclarations(PsiElement statement, String name, List<ResolveResult> results) {
        for (PsiElement statementChild : statement.getChildren()) {
            if (statementChild instanceof CStarFunctionDeclaration functionDeclaration) {
                for (PsiElement functionChild : functionDeclaration.getChildren()) {
                    if (functionChild instanceof CStarFunctionVariableDeclaration variableDeclaration) {
                        String variableName = variableDeclaration.getIdentifier().getText();
                        if (variableName.equals(name)) {
                            results.add(new PsiElementResolveResult(variableDeclaration));
                        }
                    }
                }
            }
        }
    }

    private void findVariableDeclarationsInBlock(PsiElement element, String name, List<ResolveResult> results) {
        PsiElement block = element.getParent();
        if (block instanceof CStarBlock) {
            PsiElement functionDeclaration = block.getParent();
            if (functionDeclaration instanceof CStarFunctionDeclaration) {
                CStarParameterList functionParameters = ((CStarFunctionDeclaration) functionDeclaration).getParameterList();
                if (functionParameters != null) {
                    for (CStarParameter parameter : functionParameters.getParameterList()) {
                        if (parameter.getVariableDeclaration().getText().equals(name)) {
                            results.add(new PsiElementResolveResult(parameter.getVariableDeclaration()));
                        }
                    }
                }
            } else if (functionDeclaration instanceof CStarMarchStmt) {
                CStarVariableDeclaration variableDeclaration = ((CStarMarchStmt) functionDeclaration).getVariableDeclaration();
                if (variableDeclaration.getIdentifier().getText().equals(name)) {
                    results.add(new PsiElementResolveResult(variableDeclaration));
                }
            } else if (functionDeclaration instanceof CStarEachStmt) {
                CStarVariableDeclaration variableDeclaration = ((CStarEachStmt) functionDeclaration).getVariableDeclaration();
                if (variableDeclaration.getIdentifier().getText().equals(name)) {
                    results.add(new PsiElementResolveResult(variableDeclaration));
                }
            }
        }
    }

    private PsiElement getEnclosingScope(PsiElement element) {
        PsiElement parent = element.getParent();
        while (parent != null && !(parent instanceof PsiFile || parent instanceof CStarBlock)) {
            parent = parent.getParent();
        }
        return parent;
    }

    @Override
    public @NotNull TextRange getAbsoluteRange() {
        return new TextRange(0, getElement().getTextLength());
    }

    @Override
    public PsiElement resolve() {
        ResolveResult[] results = multiResolve(false);
        return results.length > 0 ? results[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        // Optionally provide code completion variants
        return new Object[0];
    }
}