package org.macver.linty.data.types.ui;

import net.md_5.bungee.api.chat.BaseComponent;

import javax.annotation.Nullable;

public interface UIElement {

    BaseComponent render(int frameCount);

    @Nullable String id();
}
