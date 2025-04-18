package com.almazn1k.TestPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import com.almazn1k.TestPlugin.MainPlugin;

public class TestCommand implements CommandExecutor {
	private MainPlugin p;
	
	public TestCommand(MainPlugin pl) {
		p = pl;
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
			@NotNull String[] args) {
		if (args.length == 0) {
			sender.sendMessage("&b&lHZ &8-> &cToo few arguments. Help/Info expected.");
			return true;
		}

		String subCmd = args[0].toLowerCase();
		if (subCmd.equals("help")) {
			sender.sendMessage("There's no commands. Just testing subcmds!");
		}
		else if (subCmd.equals("info")) {
			sender.sendMessage("TestPlugin v1.0");
			sender.sendMessage("Author: Almazn1k");
		}
		else if (subCmd.equals("reload")) {
			p.reloadConfig();
			sender.sendMessage("Reloaded.");
		}
		
		return true;
	}

}
