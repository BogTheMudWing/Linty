package org.macver.linty.data.types.ui;

import net.md_5.bungee.api.ChatColor;
import org.macver.linty.Linty;

public enum UIColor {

    TEXT,
    SPECIAL,
    BORDERS,
    BUTTONS,
    NOTABLE,
    EMPHASIS,
    DANGEROUS,
    PROGRESS,
    ACTIVE;

    public ChatColor color;

//    static {
//        TEXT.color = (ChatColor.of(Linty.getPlugin().getConfig().getString("interface.colors.text")));
//        SPECIAL.color = (ChatColor.of(Linty.getPlugin().getConfig().getString("special")));
//        BORDERS.color = (ChatColor.of(Linty.getPlugin().getConfig().getString("borders")));
//        BUTTONS.color = (ChatColor.of(Linty.getPlugin().getConfig().getString("buttons")));
//        NOTABLE.color = (ChatColor.of(Linty.getPlugin().getConfig().getString("notable")));
//        EMPHASIS.color = (ChatColor.of(Linty.getPlugin().getConfig().getString("emphasis")));
//        DANGEROUS.color = (ChatColor.of(Linty.getPlugin().getConfig().getString("dangerous")));
//        PROGRESS.color = (ChatColor.of(Linty.getPlugin().getConfig().getString("progress")));
//        ACTIVE.color = (ChatColor.of(Linty.getPlugin().getConfig().getString("active")));
//    }

    static {
        TEXT.color = ChatColor.WHITE;
        SPECIAL.color = ChatColor.AQUA;
        BORDERS.color = ChatColor.DARK_GRAY;
        BUTTONS.color = ChatColor.GRAY;
        NOTABLE.color = ChatColor.BLUE;
        EMPHASIS.color = ChatColor.GOLD;
        DANGEROUS.color = ChatColor.RED;
        PROGRESS.color = ChatColor.GREEN;
        ACTIVE.color = ChatColor.YELLOW;
    }
}
