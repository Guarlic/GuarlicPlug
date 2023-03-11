package guarlicplug.guarlicplug.Commands;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetXYZ {
    public int getX(Player p) {
        PlayerData.createPlayerData(p);
        File f = PlayerData.getPlayerDataFile(p);

        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

        return Integer.valueOf(config.get("x").toString());
    }

    public int getY(Player p) {
        PlayerData.createPlayerData(p);
        File f = PlayerData.getPlayerDataFile(p);

        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

        return Integer.valueOf(config.get("y").toString());
    }

    public int getZ(Player p) {
        PlayerData.createPlayerData(p);
        File f = PlayerData.getPlayerDataFile(p);

        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

        return Integer.valueOf(config.get("z").toString());
    }

    public void setXYZ(Player p, int x, int y, int z) {
        PlayerData.createPlayerData(p);
        File f = PlayerData.getPlayerDataFile(p);

        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

        config.set("x", x);
        config.set("y", y);
        config.set("z", z);

        try {
            config.save(f);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetXYZ(Player p) {
        PlayerData.createPlayerData(p);
        File f = PlayerData.getPlayerDataFile(p);

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

    public boolean isReset(Player p) {
        PlayerData.createPlayerData(p);
        File f = PlayerData.getPlayerDataFile(p);

        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);

        if (config.get("x") == null) return true;
        return false;
    }
}
