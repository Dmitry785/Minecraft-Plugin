package me.dmitryname.myplugin.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class MessageCommandTabCompleter implements TabCompleter {
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> list = new ArrayList<String>();
		if(args.length == 1) {
			list.add("hello");
			list.add("goodbye");
		}
		return list;
	}
	
}
