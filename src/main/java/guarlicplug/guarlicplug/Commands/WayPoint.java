package guarlicplug.guarlicplug.Commands;

import java.util.ArrayList;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandSender;

class WayPoints {
    private UUID id;
    private int x;
    private int y;
    private int z;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID _id) {
        this.id = _id;
    }

    public void setX(int _x) {
        this.x = _x;
    }

    public void setY(int _y) {
        this.y = _y;
    }

    public void setZ(int _z) {
        this.z = _z;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }
}

public class WayPoint {
    private static ArrayList<WayPoints> waypoint_list = new ArrayList<WayPoints>();

    public static void Cset(CommandSender sender) {
        Player p = (Player) sender;

        int size = waypoint_list.size();

        for (int i = 0; i < size; i++) {
            if (waypoint_list.get(i).getId().equals(p.getUniqueId())) {
                waypoint_list.remove(i);
            }
        }

        WayPoints a = new WayPoints();

        a.setId(p.getUniqueId());
        a.setX((int) p.getLocation().x());
        a.setY((int) p.getLocation().y());
        a.setZ((int) p.getLocation().z());

        waypoint_list.add(a);

        p.sendMessage(ChatColor.GREEN + "Successfully saved coordinate.");
    }

    public static void Cget(CommandSender sender) {
        Player p = (Player) sender;
        WayPoints a = null;

        int size = waypoint_list.size();

        for (int i = 0; i < size; i++) {
            if (waypoint_list.get(i).getId().equals(p.getUniqueId())) {
                a = waypoint_list.get(i);
            }
        }

        if (a == null) {
            p.sendMessage(ChatColor.DARK_RED + "Failed to get coordinate because you didn't saved coordinate.");

            return;
        }

        p.sendMessage("Current saved coordinate: " + ChatColor.GRAY + "(" + a.getX() + ", " + a.getY() + ", " + a.getZ() + ")");
    }

    public static void Cdel(CommandSender sender) {
        Player p = (Player) sender;
        WayPoints a = null;

        int size = waypoint_list.size();
        int n = -1;

        for (int i = 0; i < size; i++) {
            if (waypoint_list.get(i).getId().equals(p.getUniqueId())) {
                a = waypoint_list.get(i);
                n = i;
            }
        }

        if (a == null && n == -1) {
            p.sendMessage(ChatColor.DARK_RED + "Failed to delete coordinate because you didn't saved coordinate.");

            return;
        }

        waypoint_list.remove(n);

        p.sendMessage(ChatColor.GREEN + "Successfully deleted saved coordinate.");
    }
}
