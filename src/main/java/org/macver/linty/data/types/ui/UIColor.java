package org.macver.linty.data.types.ui;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.macver.linty.Linty;

public enum ElementColors {

    TEXT(ChatColor.of(Linty.getPlugin().getConfig().getString("text"))),
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
//        FileConfiguration config = Linty.getPlugin().getConfig();
//        TEXT = ChatColor.of(config.getString("text"));
//        SPECIAL.color = ChatColor.of(config.getString("special"));
//        BORDERS.color = ChatColor.of(config.getString("borders"));
//        BUTTONS.color = ChatColor.of(config.getString("buttons"));
//        NOTABLE.color = ChatColor.of(config.getString("notable"));
//        EMPHASIS.color = ChatColor.of(config.getString("emphasis"));
//        DANGEROUS.color = ChatColor.of(config.getString("dangerous"));
//        PROGRESS.color = ChatColor.of(config.getString("progress"));
//        ACTIVE.color = ChatColor.of(config.getString("active"));
//    }

    ElementColors(ChatColor color) {
        this.color = color;
    }
}
