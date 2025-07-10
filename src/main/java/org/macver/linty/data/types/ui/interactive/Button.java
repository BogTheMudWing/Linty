package org.macver.linty.data.types.ui.interactive;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Button implements Interactive {

    @Nullable private final String id;
    @Nonnull
    private String text;
    private HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("This is a button."));
    private ClickEvent clickEvent = null;
    private InteractiveType type = InteractiveType.DISABLED;

    public Button(@Nullable String id, @Nonnull String text) {
        this.id = id;
        this.text = text;
    }
    public Button(@Nonnull String text) {
        id = null;
        this.text = text;
    }

    public Button setText(@Nonnull String text) {
        this.text = text;
        return this;
    }

    public Button setClickEvent(ClickEvent clickEvent) {
        this.clickEvent = clickEvent;
        return this;
    }

    public Button setHoverEvent(HoverEvent hoverEvent) {
        this.hoverEvent = hoverEvent;
        return this;
    }

    public Button setType(InteractiveType type) {
        this.type = type;
        return this;
    }

    @Nonnull
    public String getText() {
        return text;
    }

    @Override
    public HoverEvent getHoverEvent() {
        return hoverEvent;
    }

    @Override
    public ClickEvent getClickEvent() {
        return clickEvent;
    }

    @Nonnull
    @Override
    public InteractiveType getType() {
        return type;
    }

    @Nullable
    @Override
    public String id() {
        return id;
    }
}
