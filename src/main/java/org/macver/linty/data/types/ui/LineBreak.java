package org.macver.linty.data.types.ui;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.macver.linty.data.types.ui.frame.Frame;

public class LineBreak implements UIElement {

    @Override
    public BaseComponent render(int frameCount) {
        ComponentBuilder builder = new ComponentBuilder();
        String frameEdge = Frame.getFrameEdgeString(frameCount);
        builder.append(frameEdge);
        return builder.build();
    }
}
