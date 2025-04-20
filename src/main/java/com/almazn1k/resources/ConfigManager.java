package com.almazn1k.resources;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
	private static ConfigManager configmgr;
	private final FileConfiguration config;
    private ConfigManager(FileConfiguration c1) {
		config = c1;
	}
    public static ConfigManager getConfigMgr() {
		return configmgr;
	}
	public static void init(FileConfiguration c) {
		configmgr = new ConfigManager(c);
	}
	
	public String getField1() {
		return config.getString("field1");
	}
}
