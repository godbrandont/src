package me.Godbrandont.Retribution;

import me.Godbrandont.Retribution.*;
import me.Godbrandont.Retribution.BaseClasses.*;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener extends MasterListener{

	public PlayerJoinListener(Main pl) {
		super(pl);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Game.setCanStart(Bukkit.getOnlinePlayers().size() >= 2);
		
	}
}
