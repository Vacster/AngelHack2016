package com.vacster.angelhack.screens;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.vacster.angelhack.Main;
import com.vacster.angelhack.helpers.ScreenButton;
import com.vacster.angelhack.helpers.Screens;

public class MainMenuScreen extends Group {

	private TextButton clientButton, serverButton;
	private final int width = 300, height = 75;
	
	public MainMenuScreen() {
		clientButton = new TextButton("CLIENT", Main.textureLoader.getSkin(), "small");
		serverButton = new TextButton("SERVER", Main.textureLoader.getSkin(), "small");
		
		clientButton.setBounds(Main.screenWidth/2 - width/2, Main.screenHeight/2 - height, width, height);
		serverButton.setBounds(Main.screenWidth/2 - width/2, Main.screenHeight/2 + height, width, height);
	
		clientButton.clearListeners();
		clientButton.addListener(new ScreenButton(Screens.CLIENTLOBBY));
		
		serverButton.clearListeners();
		serverButton.addListener(new ScreenButton(Screens.SERVERLOBBY));
		
		addActor(clientButton);
		addActor(serverButton);
	}
	
}
