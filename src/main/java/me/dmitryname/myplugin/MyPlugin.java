package me.dmitryname.myplugin;

import org.bukkit.plugin.java.JavaPlugin;

import me.dmitryname.myplugin.commands.MessageCommand;
import me.dmitryname.myplugin.commands.MessageCommandTabCompleter;

public class MyPlugin extends JavaPlugin{
	@Override
	public void onEnable() {
		getCommand("message").setExecutor(new MessageCommand());
		getCommand("message").setTabCompleter(new MessageCommandTabCompleter());
		getLogger().info("- - - My Plugin enabled - - -");
	}
	@Override
	public void onDisable() {
		getLogger().info("- - - My Plugin disabled - - -");
	}
}
