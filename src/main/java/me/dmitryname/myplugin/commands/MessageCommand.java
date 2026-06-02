package me.dmitryname.myplugin.commands;

import java.util.Date;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length > 0) {
			Date currentTime = new Date();
			if (args[0].equalsIgnoreCase("hello"))
				sender.sendMessage(String.format("Hello %s", sender.getName()));
			if (args[0].equalsIgnoreCase("goodbye"))
				sender.sendMessage(String.format("Goodbye %s", sender.getName()));
			if (sender instanceof Player) {
				Player p = (Player) sender;
				sender.sendMessage(String.format("You are a player %s. Current time is %s", 
						p.getDisplayName(), currentTime.toString()));
			}
			return true;
		}
		return false;
	}
}
