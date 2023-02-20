package guarlicplug.guarlicplug;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.block.Action;

public class Skill {
    public static void kalis_axtra(Player p, Action a) {
        p.sendMessage(ChatColor.RED + "Kalis Axtra!");

        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 30, 5));
        p.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, p.getLocation(), 1);
        p.getWorld().spawnParticle(Particle.FLAME, p.getLocation().add(0.0, 1.0, 0.0), 100);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BLAZE_DEATH, 5, 1);
        p.getWorld().createExplosion(p.getLocation().add(0.0, 0.0, 0.0), 8.0F, false, true);
    }
}
