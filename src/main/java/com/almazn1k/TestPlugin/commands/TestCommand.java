package com.almazn1k.TestPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.almazn1k.TestPlugin.MainPlugin;
import com.almazn1k.TestPlugin.commands.subcmds.TestInfoCommand;

public class TestCommand implements CommandExecutor {
	private MainPlugin p;
	private TestInfoCommand ticmd;
	
	public TestCommand(MainPlugin pl) {
		ticmd = new TestInfoCommand();
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
			ticmd.showMessage(sender);
		}
		else if (subCmd.equals("reload")) {
			p.reloadPluginConfig();
			sender.sendMessage("Reloaded.");
			return true;
		}
		
		return true;
	}

}
