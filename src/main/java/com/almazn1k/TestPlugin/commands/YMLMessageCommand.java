package com.almazn1k.TestPlugin.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import com.almazn1k.resources.ConfigManager;

public class YMLMessageCommand implements CommandExecutor{
	private ConfigManager config;
	
	public YMLMessageCommand(ConfigManager a) {
		config = a;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
			@NotNull String[] args) {
		sender.sendMessage(config.getField1());
		return false;
	}

}
