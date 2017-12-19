package com.github.antilaby.antilaby.api;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.antilaby.antilaby.main.AntiLaby;

public class LabyModJoinCommands {

	private JavaPlugin plugin;

	public LabyModJoinCommands(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	public JavaPlugin getPlugin() {
		return plugin;
	}

	public List<String> getLabyModJoinCommands() {
		return getLabyModJoinCommands(false);
	}

	public List<String> getLabyModJoinCommands(boolean includeComments) {
		if (includeComments)
			return AntiLaby.getInstance().getConfig().getStringList("AntiLaby.LabyModPlayerCommands");
		else {
			List<String> labyModPlayerCommandsComments = AntiLaby.getInstance().getConfig()
					.getStringList("AntiLaby.LabyModPlayerCommands");
			List<String> labyModPlayerCommands = new ArrayList<>();
			for (final String command : labyModPlayerCommandsComments) {
				try {
					if (!command.startsWith("#"))
						labyModPlayerCommands.add(command);
				} catch (Exception e) {
				}
			}
			return labyModPlayerCommands;
		}
	}

}
