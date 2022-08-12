package de.chloecdn.cdnlib;

import org.bukkit.plugin.java.JavaPlugin;

public final class CDNLib {

    private static JavaPlugin plugin;

    public CDNLib(JavaPlugin plugin) {
        CDNLib.plugin = plugin;
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }
}
