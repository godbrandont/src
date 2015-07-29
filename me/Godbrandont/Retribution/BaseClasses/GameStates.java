package me.Godbrandont.Retribution.BaseClasses;

public enum GameStates {
	
	IN_LOBBY(true), IN_GAME(false), POST_GAME(false), RESETTING_GAME(false);
	
	private boolean canJoin;
	private static GameStates currentState;
	
	GameStates(boolean canJoin){
		this.canJoin = canJoin;
	}
	
	public boolean canJoin(){
		return canJoin;
	}
	
	public static void setState(GameStates state){
		GameStates.currentState = state;
	}
	
	public static boolean isState(GameStates state){
		return GameStates.currentState == state;
	}
	
	public static GameStates getstate(){
		return currentState;
	}
	
}

