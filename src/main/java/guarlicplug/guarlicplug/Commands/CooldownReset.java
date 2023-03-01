package guarlicplug.guarlicplug.Commands;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandSender;

public class CooldownReset {
    public static void cooldown_reset(CommandSender sender, ArrayList<Player> cooldown1, ArrayList<Player> cooldown2, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.DARK_RED + "Failed to reset cooldowns because you do not have op.");

            return;
        }

        if (args.length > 0) {
            Player target = sender.getServer().getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(ChatColor.DARK_RED + "Failed to reset cooldown because target is not online.");
                return;
            }

            cooldown1.remove(target);
            cooldown2.remove(target);

            sender.sendMessage(ChatColor.GREEN + "Successfully reset cooldown of " + target.getName() + ".");

            return;
        }

        cooldown1.clear();
        cooldown2.clear();

        sender.sendMessage(ChatColor.GREEN + "Successfully reset cooldowns.");
    }
}
