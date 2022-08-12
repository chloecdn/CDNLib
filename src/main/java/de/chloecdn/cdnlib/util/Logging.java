package de.chloecdn.cdnlib.util;

import de.chloecdn.cdnlib.CDNLib;

public class Logging {

    public static void info(String message) {
        CDNLib.getPlugin().getLogger().info(message);
    }

    public static void warn(String message) {
        CDNLib.getPlugin().getLogger().warning(message);
    }

    public static void error(String message) {
        CDNLib.getPlugin().getLogger().severe(message);
    }
}
