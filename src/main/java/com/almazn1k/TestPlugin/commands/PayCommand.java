package com.almazn1k.TestPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import com.almazn1k.TestPlugin.MainPlugin;

import net.milkbowl.vault.economy.Economy;

public class PayCommand implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
			@NotNull String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players can use this command");
			return true;
		}
		
		Player player = Bukkit.getPlayer(sender.getName());
		if (args.length != 2) {
			sender.sendMessage("Too few args given");
			return true;
		}
		
		Player targetPlayer = Bukkit.getPlayer(args[0]);
		if (targetPlayer == null) {
			sender.sendMessage("Player not found!");
		}
		
		try {
			double amount = Double.parseDouble(args[1]);
			Economy ec = MainPlugin.getEconomy();
			
			if (ec.has(targetPlayer, amount)) {
				ec.withdrawPlayer(player, amount);
				ec.depositPlayer(targetPlayer, amount);
				
				player.sendMessage("You paid to somebody");
				targetPlayer.sendMessage("Somebody gave you money");
			}
			else {
				player.sendMessage("You don't have money ;)");
			}
		}catch (NumberFormatException e) {
			player.sendMessage("Invalid amount!");
		}
		return true;
	}

}
