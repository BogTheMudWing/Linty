package org.macver.linty.data.types.ui.interactive;

import net.md_5.bungee.api.ChatColor;
import org.macver.linty.data.types.ui.UIColor;

public enum InteractiveType {

    NORMAL(UIColor.NOTABLE.color),
    DANGEROUS(UIColor.DANGEROUS.color),
    PROGRESSIVE(UIColor.PROGRESS.color),
    ACTIVE(UIColor.ACTIVE.color),
    DISABLED(UIColor.BUTTONS.color);

    final ChatColor color;

    InteractiveType(ChatColor color) {
        this.color = color;
    }
}
