package com.vacster.angelhack.helpers;


public enum Screens {//Super Dangerous but funny

	MAINMENU("com.vacster.angelhack.screens.MainMenuScreen"), CLIENTLOBBY("com.vacster.angelhack.screens.LobbyScreen"), SERVERLOBBY("com.vacster.angelhack.screens.LobbyScreen"),
	SERVERWAITINGROOM("com.vacster.angelhack.screens.ServerWaitingScreen"), CLIENTWAITINGROOM("com.vacster.angelhack.screens.ClientWaitingScreen"),
	CLIENTGAMEROOM("com.vacster.angelhack.screens.ClientGameScreen"), SERVERGAMEROOM("com.vacster.angelhack.screens.ServerGameScreen");

	private String str;
	
	Screens(String str)
	{
		this.str = str;
	}
	
	public String getClassName() {
		return str;
	}
}
