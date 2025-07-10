package org.macver.linty.ui;

import org.macver.linty.data.types.ui.UIElement;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class UserInterfaceRegistry {

    private static final Map<String, Class<? extends UIElement>> elementRegistry = new HashMap<>();

    @Nullable
    public static Class<? extends UIElement> getElementTypeOfString(@Nonnull String key) {
        return elementRegistry.get(key);
    }

    public static void assignElementToKey(@Nonnull Class<? extends UIElement> elementClass, @Nonnull String key) {
        elementRegistry.put(key, elementClass);
    }
}
