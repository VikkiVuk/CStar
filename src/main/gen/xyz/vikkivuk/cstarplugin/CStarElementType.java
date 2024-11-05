package xyz.vikkivuk.cstarplugin;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CStarElementType extends IElementType {

    public CStarElementType(@NotNull @NonNls String debugName) {
        super(debugName, CStarLanguage.INSTANCE);
    }

}