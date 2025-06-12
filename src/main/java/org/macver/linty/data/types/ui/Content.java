package org.macver.linty.data.types.ui;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

import javax.annotation.Nonnull;

public class Text implements UIElement {

    @Nonnull
    private BaseComponent contents = new TextComponent("null");

    public Text(@Nonnull BaseComponent component) {
        contents = component;
    }

    @Nonnull
    public BaseComponent getContents() {
        return contents;
    }

    public Text setContents(BaseComponent contents) {
        this.contents = contents;
        return this;
    }

    @Override
    public BaseComponent renderInFrames(int frameCount) {
        return null;
    }
}
