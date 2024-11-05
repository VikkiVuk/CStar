package xyz.vikkivuk.cstarplugin;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CStarTokenType extends IElementType {

    public CStarTokenType(@NotNull @NonNls String debugName) {
        super(debugName, CStarLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "xyz.vikkivuk.cstarplugin.CStarTokenType." + super.toString();
    }

}