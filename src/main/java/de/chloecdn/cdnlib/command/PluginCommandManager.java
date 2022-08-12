package de.chloecdn.cdnlib.command;

import de.chloecdn.cdnlib.CDNLib;
import de.chloecdn.cdnlib.util.Logging;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PluginCommandManager {

    /**
     * Registers the given command, that will run the given runAction when someone runs it, and also using the given tabCompleteAction.
     * NOTE: You still need to register this command in your "plugin.yml", or else it'll log an error and won't register that command.
     *
     * @param command           The name of the command to register.
     * @param runAction         the action to perform when someone runs the command.
     * @param tabCompleteAction a list of Strings used for the TabCompletion, similar to Bukkit's own implementation.
     */
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
