package com.almazn1k.TestPlugin.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class YMLMessageCommand implements CommandExecutor{
	private final FileConfiguration config;
	
	public YMLMessageCommand(FileConfiguration c) {
		config = c;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
			@NotNull String[] args) {
		sender.sendMessage(config.getString("field1"));
		return false;
	}

}
