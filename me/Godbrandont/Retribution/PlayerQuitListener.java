package me.Godbrandont.Retribution;

import me.Godbrandont.Retribution.BaseClasses.*;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener extends MasterListener{

	public PlayerQuitListener(Main pl) {
		super(pl);
	}
	
	public void onPlayerQuit(PlayerQuitEvent event){
		if(GameStates.isState(GameStates.IN_LOBBY))
			Game.setCanStart(Bukkit.getOnlinePlayers().size() - 1 >= 4);
	}
	
}
