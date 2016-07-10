package com.vacster.angelhack.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.vacster.angelhack.Main;
import com.vacster.angelhack.helpers.Screens;

public class LobbyScreen extends Group{

	private TextField TCPportField, UDPportField, IPField;
	private TextButton portButton;
	private int width = 300, height = 75;
	
	public LobbyScreen(final boolean server) {
		Gdx.app.log("Server", "Server Lobby");
			
		TCPportField = new TextField("55555", Main.textureLoader.getSkin());
		TCPportField.setBounds(Main.screenWidth/2 - width/2, Main.screenHeight/2 + height, width, height);
			
		UDPportField = new TextField("44444", Main.textureLoader.getSkin());
		UDPportField.setBounds(Main.screenWidth/2 - width/2, Main.screenHeight/2 - height/2, width, height);
		
		if(!server)
		{
			IPField = new TextField("169.254.223.42", Main.textureLoader.getSkin());//TODO fix ip
			IPField.setBounds(Main.screenWidth/2 - width/2, Main.screenHeight/2 + height * 2.5f, width, height);
		}
		
		portButton = new TextButton("OK", Main.textureLoader.getSkin(), "small");
		portButton.setBounds(Main.screenWidth/2 - width/2, Main.screenHeight/2 - height*2, width, height);
		portButton.clearListeners();
		portButton.addListener(new ClickListener()
		{
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(!server)
					Main.IP = IPField.getText();
				Main.TCPport = Integer.valueOf(TCPportField.getText());
				Main.UDPport = Integer.valueOf(UDPportField.getText());
				Main.changeScreen(server?Screens.SERVERWAITINGROOM:Screens.CLIENTWAITINGROOM);//TODO change
				super.clicked(event, x, y);
			}
		});
			
		addActor(TCPportField);
		addActor(UDPportField);
		if(!server)
			addActor(IPField);
		addActor(portButton);
	}
	
}
