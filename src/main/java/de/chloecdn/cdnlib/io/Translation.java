package de.chloecdn.cdnlib.io;

import de.chloecdn.cdnlib.CDNLib;
import de.chloecdn.cdnlib.util.KeyValuePair;
import org.bukkit.plugin.java.JavaPlugin;

public class Translation {

    private static final JavaPlugin plugin = CDNLib.getPlugin();

    @SafeVarargs
    public static String getTranslation(String entry, KeyValuePair<String, String>... replacements) {
        String s = plugin.getConfig().getString("translations." + entry, entry);
        for (KeyValuePair<String, String> replacement : replacements) {
            s = s.replace(replacement.key(), replacement.value());
        }
        return s.replace("&", "§");
    }
}
