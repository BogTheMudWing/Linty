package org.macver.linty;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import org.bukkit.plugin.java.JavaPlugin;
import org.macver.linty.commands.CommandLinty;

public final class Linty extends JavaPlugin {

    private static Linty PLUGIN;

    @Override
    public void onLoad() {
        CommandAPI.onLoad(new CommandAPIBukkitConfig(this).verboseOutput(true));

        new CommandLinty().getCommand().register();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        PLUGIN = this;

        CommandAPI.onEnable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        CommandAPI.onDisable();
    }

    public static Linty getPlugin() {
        return PLUGIN;
    }
}
