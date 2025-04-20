package com.almazn1k.TestPlugin.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.almazn1k.resources.ConfigManager;

public class YMLMessageCommand implements CommandExecutor{
	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
			@NotNull String[] args) {
		sender.sendMessage(ConfigManager.getConfigMgr().getField1());
		return false;
	}

}
