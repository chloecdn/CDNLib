package de.chloecdn.cdnlib.command;

import de.chloecdn.cdnlib.CDNLib;
import de.chloecdn.cdnlib.util.Logging;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PluginCommandManager {

    public static void register(@NotNull String command, @NotNull RunAction runAction, @Nullable TabCompleteAction tabCompleteAction) {
        if (CDNLib.getPlugin().getCommand(command) == null) {
            Logging.error("Error while registering command '" + command + "'. Did you forget to register it in your 'plugin.yml'?");
            return;
        }
        CDNLib.getPlugin().getCommand(command).setExecutor((sender, cmd, label, args) -> {
            runAction.run(sender, cmd, label, args);
            return false;
        });
        if (tabCompleteAction == null) {
            return;
        }
        CDNLib.getPlugin().getCommand(command).setTabCompleter(tabCompleteAction::tabComplete);
    }

    public interface RunAction {
        void run(CommandSender sender, Command command, String label, String[] args);
    }

    public interface TabCompleteAction {
        List<String> tabComplete(CommandSender sender, Command command, String label, String[] args);
    }
}
