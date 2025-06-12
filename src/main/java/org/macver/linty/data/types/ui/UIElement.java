package org.macver.linty.data.types.ui;

import net.md_5.bungee.api.chat.BaseComponent;

public interface UIElement {

    BaseComponent render(int frameCount);

}
