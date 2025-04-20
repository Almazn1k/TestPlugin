package com.almazn1k.resources;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
	private final FileConfiguration config;
	
	public ConfigManager(FileConfiguration c) {
		config = c;
	}
	
	public String getField1() {
		return config.getString("field1");
	}
}
