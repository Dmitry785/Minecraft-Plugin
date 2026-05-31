package me.dmitryname.myplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class MyPlugin extends JavaPlugin{
	@Override
	public void onEnable() {
		getLogger().info("- - - My Plugin enabled - - -");
	}
	@Override
	public void onDisable() {
		getLogger().info("- - - My Plugin disabled - - -");
	}
}
