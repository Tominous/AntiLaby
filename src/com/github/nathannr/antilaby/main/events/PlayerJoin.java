package com.github.nathannr.antilaby.main.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.nathannr.antilaby.api.antilabypackages.AntiLabyPackager;
import com.github.nathannr.antilaby.main.AntiLaby;
import com.github.nathannr.antilaby.metrics.BStats;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		// Disable LabyMod functions for the new player
		AntiLabyPackager pack = new AntiLabyPackager(p);
		pack.sendPackages();

		if (p.getUniqueId().toString().equals("a4395e2f-cddd-466c-a0b2-d5c2fcf44c45")) {
			p.sendMessage(
					"�aThis server uses AntiLaby version �b" + AntiLaby.getInstance().getDescription().getVersion()
							+ "�a with NMS version �b" + AntiLaby.getInstance().getNmsver() + "�a.");
			String bStats;
			String mcStats;
			if (BStats.enabled) {
				bStats = "enabled";
			} else {
				bStats = "disabled";
			}
			if (AntiLaby.getInstance().getMetrics().isOptOut()) {
				mcStats = "disabled";
			} else {
				mcStats = "enabled";
			}
			p.sendMessage("�aMCStats: �b" + mcStats + "�a, bStats: �b" + bStats + "�e�r");
		}
	}

}
