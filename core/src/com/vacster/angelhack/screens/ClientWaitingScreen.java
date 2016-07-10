package com.vacster.angelhack.screens;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.vacster.angelhack.Main;
import com.vacster.angelhack.helpers.KryoHelper;
import com.vacster.angelhack.helpers.Screens;

public class ClientWaitingScreen extends Group{

	private Label waitingLabel;
	
	public ClientWaitingScreen() {
		Main.client = new Client();
		Main.client.addListener(new Listener(){
			@Override
			public void connected(Connection arg0) {
				Main.client.removeListener(this);
				Main.changeScreen(Screens.CLIENTGAMEROOM);//TODO make it wait for StartGamePacket
				super.connected(arg0);
			}
		});
		Main.client.start();
		try {
			Main.client.connect(5000, Main.IP, Main.TCPport, Main.UDPport);
		} catch (IOException e) {
			Gdx.app.log("Debug", e.getMessage());
		} 
		KryoHelper.registerClasses(Main.client.getKryo());
		
		
		
		waitingLabel = new Label("WAITING TO START", Main.textureLoader.getSkin(), "small");
		waitingLabel.setPosition(Main.screenWidth/2 - waitingLabel.getWidth()/2, Main.screenHeight/2 + 200);
		addActor(waitingLabel);
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
	}
	
}
