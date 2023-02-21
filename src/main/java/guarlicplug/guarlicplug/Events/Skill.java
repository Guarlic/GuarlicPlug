package guarlicplug.guarlicplug.Events;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Skill {
    public static void kalis_axtra(Player p) {
        if (!p.isOp()) {
            p.sendMessage(ChatColor.DARK_RED + "Failed to use 'Kalis Axtra' because you do not have op.");

            return;
        }

        p.sendMessage(ChatColor.RED + "Kalis Axtra!");

        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30, 5, false, false));
        p.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, p.getLocation(), 1);
        p.getWorld().spawnParticle(Particle.FLAME, p.getLocation().add(0.0, 1.0, 0.0), 100);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BLAZE_DEATH, 5, 1);
        p.getWorld().createExplosion(p.getLocation().add(0.0, 0.0, 0.0), 8.0F, false, true);
    }

    public static void ultra_armor(Player p) {
        p.sendMessage(ChatColor.GOLD + "金剛火災!");

        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 5, false, false));
        p.getWorld().spawnParticle(Particle.LAVA, p.getLocation(), 10);
        p.getWorld().spawnParticle(Particle.FLAME, p.getLocation().add(0.0, 1.0, 0.0), 100);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 5, 1);
    }
}
