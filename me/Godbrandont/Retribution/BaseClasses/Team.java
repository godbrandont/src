package me.Godbrandont.Retribution.BaseClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Team {
	
	private static List<Team> allTeams = new ArrayList<Team>();
	private static HashMap<String,Team> playerTeams = new HashMap<String,Team>();
	
	private String teamName;
	private static Location spawn;
	
	public Team(String teamName, Location spawn){
		this.teamName = teamName.trim();
		Team.spawn = spawn;
		allTeams.add(this);
	}
	
	public String getName(){
		return teamName;
	}
	
	public void add(Player player){
		playerTeams.put(player.getName(), this);
	}
	
	public boolean remove(Player player){
		if(!hasTeam(player))
			return false;
		playerTeams.remove(player.getName());
		return true;
	}
	
	public static Location getSpawn(){
		return spawn;
	}
	
	public static boolean hasTeam(Player player){
		return playerTeams.containsKey(player.getName());
	}
	
	public static Team getTeam(Player player){
		if(!hasTeam(player))
			return null;
		return playerTeams.get(player.getName());
	}
	
	public static Team getTeam(String name){
		for (Team t : allTeams)
			if(t.teamName.equalsIgnoreCase(name))
				return t;
		return null;
		
	}
	
	public static List<Team> getAllTeams(){
		return allTeams;
	}

}
