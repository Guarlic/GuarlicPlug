package guarlicplug.guarlicplug.Commands;

import java.util.Vector;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryCommand {
    public static void inv(CommandSender sender) {
        Player p = (Player) sender;

        if (!p.isOp()) {
            p.sendMessage(ChatColor.DARK_RED + "Failed to open inventory because you do not have op.");

            return;
        }

        Inventory i = Bukkit.createInventory(p, 27, ChatColor.LIGHT_PURPLE + "Inventory");

        ItemStack item1 = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemStack item2 = new ItemStack(Material.ELYTRA, 1);
        ItemStack item3 = new ItemStack(Material.SHIELD, 1);
        ItemStack item4 = new ItemStack(Material.GOLDEN_SWORD, 1);

        ItemMeta meta1 = item1.getItemMeta();
        ItemMeta meta2 = item2.getItemMeta();
        ItemMeta meta3 = item3.getItemMeta();
        ItemMeta meta4 = item4.getItemMeta();

        Vector<String> lore1 = new Vector<String>();
        Vector<String> lore2 = new Vector<String>();
        Vector<String> lore3 = new Vector<String>();
        Vector<String> lore4 = new Vector<String>();

        lore1.add(ChatColor.LIGHT_PURPLE + "이것은 오래전 청룡의 비늘을 하나하나 모아 만든 전설의 검이다..");
        lore2.add(ChatColor.AQUA + "흑도 청룡검" + ChatColor.LIGHT_PURPLE + "으로 흑룡을 베어 얻은 날개 조각 중 하나이다..");
        lore3.add(ChatColor.RED + "흑룡의 역린을 떼어 붙인 방패이다..");
        lore4.add(ChatColor.GOLD + "이곳의 10가지 명검 중 하나이다. 흑도 청룡검 또한 명검에 속한다..");

        meta1.setDisplayName(ChatColor.AQUA + "흑도 청룡검");
        meta1.addEnchant(Enchantment.DAMAGE_ALL, 255, true);
        meta1.setLore(lore1);
        meta1.setUnbreakable(true);

        meta2.setDisplayName(ChatColor.LIGHT_PURPLE + "흑룡의 날개 조각");
        meta2.addEnchant(Enchantment.MENDING, 255, true);
        meta2.setLore(lore2);

        meta3.setDisplayName(ChatColor.GOLD + "역린의 방패");
        meta3.addEnchant(Enchantment.THORNS, 255, true);
        meta3.setLore(lore3);
        meta3.setUnbreakable(true);

        meta4.setDisplayName(ChatColor.YELLOW + "ムラマサ");
        meta4.addEnchant(Enchantment.DAMAGE_ALL, 255, true);
        meta4.setLore(lore4);
        meta4.setUnbreakable(true);

        item1.setItemMeta(meta1);
        item2.setItemMeta(meta2);
        item3.setItemMeta(meta3);
        item4.setItemMeta(meta4);

        i.setItem(10, item1);
        i.setItem(13, item2);
        i.setItem(16, item3);
        i.setItem(19, item4);

        p.sendMessage(ChatColor.LIGHT_PURPLE + "Inventory has opened.");
        p.openInventory(i);
    }
}
