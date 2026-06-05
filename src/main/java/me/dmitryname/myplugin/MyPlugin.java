package me.dmitryname.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.dmitryname.myplugin.commands.MessageCommand;
import me.dmitryname.myplugin.commands.GetSigarreteCommand;
import me.dmitryname.myplugin.commands.MessageCommandTabCompleter;
import me.dmitryname.myplugin.events.SigaretteEventListener;

public class MyPlugin extends JavaPlugin{
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new SigaretteEventListener(), this);
		getCommand("message").setExecutor(new MessageCommand());
		getCommand("getSigarette").setExecutor(new GetSigarreteCommand());
		getCommand("message").setTabCompleter(new MessageCommandTabCompleter());
		getLogger().info("- - - My Plugin enabled - - -");
	}
	@Override
	public void onDisable() {
		getLogger().info("- - - My Plugin disabled - - -");
	}
}
