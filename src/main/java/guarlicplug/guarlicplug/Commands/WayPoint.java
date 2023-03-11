package guarlicplug.guarlicplug.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandSender;

public class WayPoint {
    public static void waypoint(CommandSender sender, String[] args) {
        switch (args[0]) {
            case "set":
                Cset(sender);
                break;

            case "get":
                Cget(sender);
                break;

            case "del":
                Cdel(sender);
                break;

            default:
                sender.sendMessage(ChatColor.DARK_RED + "Failed to use waypoint command because wrong argument.");
        }
    }

    private static void Cset(CommandSender sender) {
        Player p = (Player) sender;
        SetXYZ s = new SetXYZ();

        int x = (int) p.getLocation().x();
        int y = (int) p.getLocation().y();
        int z = (int) p.getLocation().z();

        s.setXYZ(p, x, y, z);

        p.sendMessage(ChatColor.GREEN + "Successfully saved coordinate.");
    }

    private static void Cget(CommandSender sender) {
        Player p = (Player) sender;
        SetXYZ s = new SetXYZ();

        if (s.isReset(p)) {
            p.sendMessage(ChatColor.DARK_RED + "Failed to get coordinate because you didn't saved coordinate.");

            return;
        }

        p.sendMessage("Current saved coordinate: " + ChatColor.GRAY + "(" + s.getX(p) + ", " + s.getY(p) + ", " + s.getZ(p) + ")");
    }

    private static void Cdel(CommandSender sender) {
        Player p = (Player) sender;
        SetXYZ s = new SetXYZ();

        if (s.isReset(p)) {
            p.sendMessage(ChatColor.DARK_RED + "Failed to delete coordinate because you didn't saved coordinate.");

            return;
        }

        s.resetXYZ(p);

        p.sendMessage(ChatColor.GREEN + "Successfully deleted saved coordinate.");
    }
}
