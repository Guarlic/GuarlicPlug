package guarlicplug.guarlicplug.Commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import guarlicplug.guarlicplug.Main;

public class PlayerData {
    public static boolean existsPlayerData(Player p) {
        File f = new File(Main.getPlugin().getDataFolder() + "/player-data/", p.getUniqueId().toString() + ".yml");

        if (f.exists()) return true;

        return false;
    }

    public static void createPlayerData(Player p) {
        if (!existsPlayerData(p)) {
            File f = new File(Main.getPlugin().getDataFolder() + "/player-data/", p.getUniqueId().toString() + ".yml");

            try {
                f.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

            config.set("x", null);
            config.set("y", null);
            config.set("z", null);

            try {
                config.save(f);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static File getPlayerDataFile(Player p) {
        if (existsPlayerData(p))
            return new File(Main.getPlugin().getDataFolder() + "/player-data/", p.getUniqueId().toString() + ".yml");

        return null;
    }
}
