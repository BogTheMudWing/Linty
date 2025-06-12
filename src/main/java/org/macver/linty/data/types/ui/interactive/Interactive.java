package org.macver.linty.data.types.ui;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;

public interface Interactive {

    HoverEvent hoverEvent = null;
    ClickEvent clickEvent = null;
    boolean clickable = false;


}
