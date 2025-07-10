package org.macver.linty.data.types.ui.interactive;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.macver.linty.data.types.ui.UIColor;
import org.macver.linty.data.types.ui.UIElement;
import org.macver.linty.data.types.ui.frame.Frame;

import javax.annotation.Nonnull;

public interface Interactive extends UIElement {

    /**
     * Get the {@link HoverEvent} of this Interactive.
     * @return {@link HoverEvent}, possibly `null`.
     */
    HoverEvent getHoverEvent();
    /**
     * Get the {@link ClickEvent} of this Interactive.
     * @return {@link ClickEvent}, possibly `null`.
     */
    ClickEvent getClickEvent();
    /**
     * Get the {@link InteractiveType} of this Interactive.
     * @return {@link InteractiveType}.
     */
    @Nonnull
    InteractiveType getType();

    String getText();

    @Override
    default BaseComponent render(int frameCount) {
        ComponentBuilder builder = new ComponentBuilder();
        String frameEdge = Frame.getFrameEdgeString(frameCount);
        builder.append(frameEdge).color(UIColor.BORDERS.color).append(" ").append(renderAlone());
        return builder.build();
    }

    default BaseComponent renderAlone() {
        ComponentBuilder builder = new ComponentBuilder();
        builder.append("[").color(UIColor.BUTTONS.color).append(this.getText()).color(getType().color).event(this.getHoverEvent()).event(this.getClickEvent()).append("]").color(UIColor.BUTTONS.color);
        return builder.build();
    }
}
