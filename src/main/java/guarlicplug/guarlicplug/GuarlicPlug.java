package guarlicplug.guarlicplug;

import java.util.ArrayList;

import org.bukkit.Bukkit;
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


public final class GuarlicPlug extends JavaPlugin implements Listener, CommandExecutor {

    private ArrayList<Player> k_cooldown = new ArrayList<Player>();
    private ArrayList<Player> u_cooldown = new ArrayList<Player>();

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
                    if (!k_cooldown.contains(p)) {
                        Skill.kalis_axtra(p);

                        k_cooldown.add(p);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
                            k_cooldown.remove(p);
                        }, 100);
                    }
                    else {
                        p.sendMessage(ChatColor.DARK_RED + "Failed to use 'Kalis Axtra' because of cooldown.");
                    }
                }
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_SWORD)) {
                if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "ムラマサ")) {
                    if (!u_cooldown.contains(p)) {
                        Skill.ultra_armor(p);

                        u_cooldown.add(p);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
                            u_cooldown.remove(p);
                        }, 600);
                    }
                    else {
                        p.sendMessage(ChatColor.DARK_RED + "Failed to Use '金剛火災' because of cooldown.");
                    }
                }
            }
        }
    }
}
