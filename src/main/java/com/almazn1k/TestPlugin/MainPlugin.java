package com.almazn1k.TestPlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.almazn1k.TestPlugin.commands.GiveItemCommand;
import com.almazn1k.TestPlugin.commands.PayCommand;
import com.almazn1k.TestPlugin.commands.TestCommand;
import com.almazn1k.TestPlugin.commands.YMLMessageCommand;
import com.almazn1k.resources.ConfigManager;

import net.milkbowl.vault.economy.Economy;

public class MainPlugin extends JavaPlugin {
	private static Economy ec = null;
	private ConfigManager cmanager;
	
	@Override
	 public void onEnable() {
		if (!checkEconomy()) {
			getLogger().severe("Vault is not found! Disabling...");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		getLogger().info("Loading configuration...");
		saveDefaultConfig();
		reloadConfig();
		cmanager = new ConfigManager(getConfig());
		
		getLogger().info("Loading commands...");
		getCommand("test").setExecutor(new TestCommand(this));
		getLogger().info("1/4 loaded. 3 left...");
		getCommand("giveitem").setExecutor(new GiveItemCommand());
		getLogger().info("2/4 loaded. 2 left...");
		getCommand("givemoney").setExecutor(new PayCommand());
		getLogger().info("2/4 loaded. 2 left...");
		getCommand("ymltest").setExecutor(new YMLMessageCommand(cmanager));
		getLogger().info("Plugin enabled!");
		// Register commands/events here
	 }
	
	public boolean checkEconomy() {
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		ec = rsp.getProvider();
		return ec != null;
	}
	
	public static Economy getEconomy() {
		return ec;
	}
	
	public void reloadPluginConfig() {
		reloadConfig();
		cmanager = new ConfigManager(getConfig());
	}

	 @Override
	 public void onDisable() {
		 getLogger().info("Plugin disabled!");
	 }
}
