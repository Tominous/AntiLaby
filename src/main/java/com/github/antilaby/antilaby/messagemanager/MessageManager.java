package com.github.antilaby.antilaby.messagemanager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.github.antilaby.antilaby.lang.impl.LanguageManager;
import com.github.antilaby.antilaby.util.Constants;

public class MessageManager {

	public static String getAsChatMessage(String message) {
		message = replaceVariables(message);
		message = Constants.PREFIX + message;
		return message;
	}
	
	public static String getAsChatMessage(String message, Player player) {
		message = replaceVariables(message, player);
		message = Constants.PREFIX + message;
		return message;
	}

	public static List<String> getAsCommands(List<String> commands, Player player) {
		final ArrayList<String> convertedCommands = new ArrayList<>();
		for (String command : commands) {
			try {
				if (command.startsWith("#")) command = null;
				command = command.replace("/", "");
				command = replacePlayer(command, player);
			} catch (final Exception e) {}
			if (command != null) convertedCommands.add(command);
		}
		return convertedCommands;
	}

	public static String getNoPermissionMessage(Player player) {
		return LanguageManager.INSTANCE.translate("antilaby.command.noPermission", player);
	}

	private static String replacePlayer(String message, Player player) {
		message = message.replace("%PLAYER%", player.getName());
		message = message.replace("%PLAYERUUID%", player.getUniqueId().toString());
		return message;
	}

	public static String replaceVariables(String message) {
		message = ChatColor.translateAlternateColorCodes('&', message);
		return message;
	}
	
	public static String replaceVariables(String message, Player player) {
		message = ChatColor.translateAlternateColorCodes('&', message);
		try {
			message = replacePlayer(message, player);
		} catch (final Exception e) {}
		return message;
	}

}