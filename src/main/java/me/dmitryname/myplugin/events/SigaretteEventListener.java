package me.dmitryname.myplugin.events;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SigaretteEventListener implements Listener{
	@EventHandler
	void onSmoke(PlayerInteractEvent e) {
		Player p = (Player)e.getPlayer();
		ItemStack item = p.getInventory().getItemInMainHand();
		if(item.getType() != Material.STICK)
			return;
		if(e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) 
			return;
			
		ItemMeta meta = item.getItemMeta();
		List<String> lore = meta.getLore();
		try {
			int count = Integer.parseInt(lore.get(0));
			if(count<=0)
			{
				p.sendMessage("Сигарета пуста");
				p.getInventory().setItemInHand(null);
				return;
			}
			count-=1;
			lore.set(0, String.format("%d", count));
		}
		catch (Exception _) {
			return;
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));
		org.bukkit.Location smokeLoc = p.getEyeLocation();
		smokeLoc.add(smokeLoc.getDirection().multiply(1.0));
		p.getWorld().spawnParticle(
			    Particle.SMOKE_LARGE, 
			    p.getEyeLocation(),    
			    10,                     
			    0.25, 0.25, 0.25,      
			    0.001                   
			);

		e.setCancelled(true);
	}
}
