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
import guarlicplug.guarlicplug.Commands.CooldownReset;
import guarlicplug.guarlicplug.Commands.WayPoint;
import guarlicplug.guarlicplug.Events.Skill;


public final class Main extends JavaPlugin implements Listener, CommandExecutor {

    private ArrayList<Player> k_cooldown = new ArrayList<Player>();
    private ArrayList<Player> u_cooldown = new ArrayList<Player>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("GuarlicPlug is Enabled!");
        getServer().getPluginManager().registerEvents(this, this);

        getCommand("happy").setExecutor(this);
        getCommand("angry").setExecutor(this);
        getCommand("inv").setExecutor(this);
        getCommand("cooldown_reset").setExecutor(this);
        getCommand("set").setExecutor(this);
        getCommand("get").setExecutor(this);
        getCommand("del").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("GuarlicPlug is Disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Commands
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

            case "cooldown_reset":
                CooldownReset.cooldown_reset(sender, k_cooldown, u_cooldown, args);
                break;

            case "set":
                WayPoint.Cset(sender);
                break;

            case "get":
                WayPoint.Cget(sender);
                break;

            case "del":
                WayPoint.Cdel(sender);
                break;
        }

        return true;
    }

    @EventHandler
    public void Join(PlayerJoinEvent event) {
        // Player Join
        Player p = event.getPlayer();

        p.sendMessage(ChatColor.GOLD + "Welcome to this server, " + ChatColor.LIGHT_PURPLE + p.getDisplayName() + "!");

        if (!p.hasPlayedBefore()) {
            for (Player g : p.getWorld().getPlayers()) {
                g.sendMessage(ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.DARK_GRAY + " has joined this server " + ChatColor.RED + "FIRST TIME!");
            }
        }
    }

    @EventHandler
    public void Skill(PlayerInteractEvent event) {
        // Skills
        Player p = event.getPlayer();
        Action a = event.getAction();

        // Kalis Axtra
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

            // 金剛火災
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
