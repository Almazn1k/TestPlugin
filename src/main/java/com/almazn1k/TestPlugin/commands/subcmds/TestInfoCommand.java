package com.almazn1k.TestPlugin.commands.subcmds;

import org.bukkit.command.CommandSender;

public class TestInfoCommand{
	public void showMessage(CommandSender sender) {
		sender.sendMessage("TestPlugin v1.4");
	}
}
