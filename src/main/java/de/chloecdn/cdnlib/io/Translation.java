package de.chloecdn.cdnlib.io;

import de.chloecdn.cdnlib.CDNLib;
import de.chloecdn.cdnlib.util.KeyValuePair;
import org.bukkit.plugin.java.JavaPlugin;

public class Translation {

    private static final JavaPlugin plugin = CDNLib.getPlugin();

    /**
     * This can be used to translate messages into different languages, or generally make messages configurable.
     * In the config.yml, they'll always be taken from the path "translations.yourEntry"
     * @param entry the entry name of your translation.
     * @param replacements the replacements you want to use. Useful if in your config you use messages like "{player} joined the game"
     * @return the translated String, or the given entry if none found.
     */
    @SafeVarargs
    public static String getTranslation(String entry, KeyValuePair<String, String>... replacements) {
        String s = plugin.getConfig().getString("translations." + entry, entry);
        for (KeyValuePair<String, String> replacement : replacements) {
            s = s.replace(replacement.key(), replacement.value());
        }
        return s.replace("&", "§");
    }
}
