package org.macver.linty.data.types.ui.interactive;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.macver.linty.data.types.ui.UIElement;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Tab implements Interactive {

    @Nonnull
    private String text;
    @Nonnull
    private List<UIElement> contents = new ArrayList<>();
    @Nullable
    private HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("This is a tab."));
    @Nullable
    private ClickEvent clickEvent = null;
    @Nonnull
    private InteractiveType type = InteractiveType.DISABLED;

    public Tab(@Nonnull String text) {
        this.text = text;
    }

    public void setText(@Nonnull String text) {
        this.text = text;
    }

    @Nonnull
    public Tab setHoverEvent(HoverEvent hoverEvent) {
        this.hoverEvent = hoverEvent;
        return this;
    }

    @Nonnull
    public Tab setClickEvent(ClickEvent clickEvent) {
        this.clickEvent = clickEvent;
        return this;
    }

    @Nonnull
    public Tab setType(@Nonnull InteractiveType type) {
        this.type = type;
        return this;
    }

    @Nonnull
    public Tab setContents(@Nonnull List<UIElement> contents) {
        this.contents = contents;
        return this;
    }

    @Nonnull
    public Tab setContents(@Nonnull UIElement... contents) {
        this.contents = List.of(contents);
        return this;
    }

    @Nonnull
    public Tab appendContents(@Nonnull List<UIElement> contents) {
        this.contents.addAll(contents);
        return this;
    }

    @Nonnull
    public Tab appendContents(@Nonnull UIElement... contents) {
        this.contents.addAll(List.of(contents));
        return this;
    }

    @Nullable
    @Override
    public HoverEvent getHoverEvent() {
        return hoverEvent;
    }

    @Nullable
    @Override
    public ClickEvent getClickEvent() {
        return clickEvent;
    }

    @Nonnull
    @Override
    public InteractiveType getType() {
        return type;
    }

    @Nonnull
    @Override
    public String getText() {
        return text;
    }

    @Nonnull
    public List<UIElement> getContents() {
        return contents;
    }
}
