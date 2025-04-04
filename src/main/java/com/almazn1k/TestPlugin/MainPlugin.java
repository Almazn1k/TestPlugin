package com.almazn1k.TestPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import com.almazn1k.TestPlugin.commands.GiveItemCommand;
import com.almazn1k.TestPlugin.commands.TestCommand;

public class MainPlugin extends JavaPlugin {
	@Override
	 public void onEnable() {
		getLogger().info("Loading commands...");
		getCommand("test").setExecutor(new TestCommand());
		getLogger().info("1/2 loaded. 1 left...");
		getCommand("giveitem").setExecutor(new GiveItemCommand());
		getLogger().info("2/2 loaded. 0 left...");
		getLogger().info("Plugin enabled!");
		// Register commands/events here
	 }

	 @Override
	 public void onDisable() {
		 getLogger().info("Plugin disabled!");
	 }
}
