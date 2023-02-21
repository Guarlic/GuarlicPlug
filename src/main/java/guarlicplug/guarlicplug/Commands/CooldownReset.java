package guarlicplug.guarlicplug.Commands;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandSender;
public class CooldownReset {
    public static void cooldown_reset(CommandSender sender, ArrayList<Player> cooldown1, ArrayList<Player> cooldown2) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.DARK_RED + "Failed to reset cooldowns because you do not have op.");

            return;
        }

        cooldown1.clear();
        cooldown2.clear();
    }
}
