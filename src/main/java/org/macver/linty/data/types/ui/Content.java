package org.macver.linty.data.types.ui;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.macver.linty.data.types.ui.frame.Frame;

import javax.annotation.Nonnull;

public class Content implements UIElement {

    @Nonnull
    private BaseComponent contents;

    public Content(@Nonnull BaseComponent component) {
        contents = component;
    }

    @Nonnull
    public BaseComponent getContents() {
        return contents;
    }

    public Content setContents(BaseComponent contents) {
        this.contents = contents;
        return this;
    }

    @Override
    public BaseComponent render(int frameCount) {
        ComponentBuilder builder = new ComponentBuilder();
        String frameEdge = Frame.getFrameEdgeString(frameCount);
        builder.append(frameEdge).color(UIColor.BORDERS.color).append(" ").append(this.getContents()).color(UIColor.TEXT.color);
        return builder.build();
    }
}
