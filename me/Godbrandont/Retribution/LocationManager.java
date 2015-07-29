package me.Godbrandont.Retribution;

import me.Godbrandont.Retribution.BaseClasses.*;

import org.bukkit.entity.Player;

public class LocationManager {
	public static void teleportToGame(Player player, Team team){
		player.teleport(Team.getSpawn());
	}
}
