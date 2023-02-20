package guarlicplug.guarlicplug;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.Particle;

public class Emoji {
    public static void happy(CommandSender sender) {
        Player p = (Player) sender;

        p.sendMessage(ChatColor.LIGHT_PURPLE + "HAPPY!");
        p.getWorld().spawnParticle(Particle.HEART, p.getLocation().add(0.0, 2.0, 0.0), 1);
    }

    public static void angry(CommandSender sender) {
        Player p = (Player) sender;

        p.sendMessage(ChatColor.RED + "ANGRY!");
        p.getWorld().spawnParticle(Particle.VILLAGER_ANGRY, p.getLocation().add(0.0, 2.0, 0.0), 1);
    }
}
