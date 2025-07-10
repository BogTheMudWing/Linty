package org.macver.linty.data.types.ui.frame;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.macver.linty.data.types.ui.UIColor;
import org.macver.linty.data.types.ui.UIElement;
import org.macver.linty.data.types.ui.interactive.Button;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class SimpleFrame implements Frame {

    @Nonnull
    private List<UIElement> elements = new ArrayList<>();
    @Nonnull
    private List<Button> buttons = new ArrayList<>();
    @Nullable
    private String title = null;
    @Nullable
    private final String id;

    public SimpleFrame() {
        this.id = null;
    }

    public SimpleFrame(@Nullable String title) {
        this.id = null;
        this.title = title;
    }

    public SimpleFrame(@Nullable String id, @Nullable String title) {
        this.id = id;
        this.title = title;
    }

    @Nonnull
    public SimpleFrame setElements(@Nonnull List<UIElement> elements) {
        this.elements = elements;
        return this;
    }

    @Nonnull
    public SimpleFrame setButtons(@Nonnull List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    @Nonnull
    public SimpleFrame setButtons(@Nonnull Button... buttons) {
        this.buttons = List.of(buttons);
        return this;
    }

    @Nonnull
    public SimpleFrame setTitle(@Nullable String title) {
        this.title = title;
        return this;
    }

    @Nonnull
    public SimpleFrame setElements(UIElement... elements) {
        this.elements = List.of(elements);
        return this;
    }

    @Nonnull
    public SimpleFrame appendContents(@Nonnull List<UIElement> elements) {
        this.elements.addAll(elements);
        return this;
    }

    @Nonnull
    public SimpleFrame appendContents(@Nonnull UIElement... elements) {
        this.elements.addAll(List.of(elements));
        return this;
    }

    @Nonnull
    @Override
    public List<Button> getButtons() {
        return buttons;
    }

    @Nullable
    @Override
    public String getTitle() {
        return title;
    }

    @Nonnull
    public List<UIElement> getElements() {
        return elements;
    }

    @Override
    public BaseComponent render(int frameCount) {
        // Initialize component builder
        ComponentBuilder builder = new ComponentBuilder();
        String outerFrameEdge = Frame.getFrameEdgeString(frameCount);
        String innerFrameEdge = Frame.getFrameEdgeString(frameCount + 1);
        // Create title bar
        builder.append(outerFrameEdge).color(UIColor.BORDERS.color).append("┌").color(UIColor.BORDERS.color).append(this.getTitle()).color(UIColor.EMPHASIS.color).append("───\n").bold(false).color(UIColor.BORDERS.color);

        // Elements are defined in the frame itself
        List<UIElement> elements = this.getElements();

        frameCount++;

        // Append to builder
        builder.append(innerFrameEdge).color(UIColor.BORDERS.color).append("\n");
        for (UIElement element : elements) {
            builder.append(element.render(frameCount)).append("\n").reset();
        }

        // Create bottom bar
        builder.append(bottomBar(frameCount));

        return builder.build();

    }

    @Nullable
    @Override
    public String id() {
        return id;
    }
}
