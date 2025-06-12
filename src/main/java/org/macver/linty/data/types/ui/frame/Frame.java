package org.macver.linty.data.types.ui.frame;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.macver.linty.data.types.ui.UIColor;
import org.macver.linty.data.types.ui.interactive.Button;
import org.macver.linty.data.types.ui.UIElement;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public interface Frame extends UIElement {

    @Nonnull
    List<Button> getButtons();
    @Nullable
    String getTitle();

    default BaseComponent build() {

        ComponentBuilder builder = new ComponentBuilder();

        int frameCount = 0;

        this.render(frameCount);

        return builder.build();
    }

    @Nonnull
    static String getFrameEdgeString(int frameCount) {
        return "│".repeat(Math.max(0, frameCount));
    }

    default BaseComponent bottomBar(int frameCount) {
        String frameEdgeString = Frame.getFrameEdgeString(frameCount);
        String outerFrameEdgeString = Frame.getFrameEdgeString(frameCount - 1);
        ComponentBuilder builder = new ComponentBuilder();
        builder.append(frameEdgeString).color(UIColor.BORDERS.color).append("\n").append(outerFrameEdgeString).color(UIColor.BORDERS.color).append("└").color(UIColor.BORDERS.color);
        for (Button button : this.getButtons()) {
            builder.append(button.renderAlone()).append("─").color(UIColor.BORDERS.color);
        }
        builder.append("──").color(UIColor.BORDERS.color);
        return builder.build();
    }

}
