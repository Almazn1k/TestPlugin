package com.almazn1k.TestPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GiveItemCommand implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
			@NotNull String[] args) {
		// TODO Auto-generated method stub
		if (args.length < 2) {
			sender.sendMessage("Too few arguments given");
			return true;
		}
		
		Player targetPlayer = Bukkit.getPlayer(args[0]);
		if (targetPlayer == null) {
			sender.sendMessage("Player not found!");
			return true;
		}
		
		Material targetMaterial = Material.matchMaterial(args[1].toUpperCase());
		if (targetMaterial == null) {
			sender.sendMessage("Item not found!");
			return true;
		}
		
		int amount = 1;
		if (args.length >= 3) {
			try{
				amount = Integer.parseInt(args[2]);
			}
			catch(NumberFormatException e) {
				sender.sendMessage("Invalid argument given: amount is "+args[2]+"when it must be from 1 to 64");
			}
		}
		ItemStack item = new ItemStack(targetMaterial, amount);
		targetPlayer.getInventory().addItem(item);
		sender.sendMessage("Given "+amount+" "+targetMaterial.name().toLowerCase()+"(-s) to "+targetPlayer.getName());
		
		return true;
	}

}
