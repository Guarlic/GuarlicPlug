package guarlicplug.guarlicplug;

import org.bukkit.Material;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.block.Action;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import guarlicplug.guarlicplug.Commands.Emoji;
import guarlicplug.guarlicplug.Commands.InventoryCommand;
import guarlicplug.guarlicplug.Events.Skill;

public final class Main extends JavaPlugin implements Listener, CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);

        getCommand("happy").setExecutor(this);
        getCommand("angry").setExecutor(this);
        getCommand("inv").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        switch (command.getName()) {
            case "happy":
                Emoji.happy(sender);
                break;

            case "angry":
                Emoji.angry(sender);
                break;

            case "inv":
                InventoryCommand.inv(sender);
                break;
        }

        return true;
    }

    @EventHandler
    public void Join(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        p.sendMessage(ChatColor.GOLD + "Welcome to this server, " + ChatColor.LIGHT_PURPLE + p.getDisplayName() + "!");
    }

    @EventHandler
    public void Skill(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Action a = event.getAction();

        if (a.equals(Action.LEFT_CLICK_AIR) || a.equals(Action.LEFT_CLICK_BLOCK)) {
            if (p.getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_SWORD)) {
                if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "흑도 청룡검")) {
                    Skill.kalis_axtra(p);
                }
            }
        }
    }
}
