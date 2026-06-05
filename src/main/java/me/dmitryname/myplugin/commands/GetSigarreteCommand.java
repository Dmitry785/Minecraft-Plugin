package me.dmitryname.myplugin.commands;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GetSigarreteCommand implements CommandExecutor {
	static int sigaretteId=0;
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length>0) {
			try {
				Player p = (Player) sender;
				int usageCount = Integer.parseInt(args[0]);
				ItemStack item = new ItemStack(Material.STICK);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("Sigarette");
				ArrayList<String> lore = new ArrayList<String>();
				lore.add(String.format("%d", usageCount));
				lore.add(String.format("Id: %d", sigaretteId++));
				meta.setLore(lore);
				meta.addEnchant(Enchantment.ARROW_FIRE, 1, false);
				item.setItemMeta(meta);
				p.getInventory().addItem(item);
				return true;
			}
			catch (Exception e){
				sender.sendMessage("Неправильный usageCount");
			}
		}
		return false;
	}

}
