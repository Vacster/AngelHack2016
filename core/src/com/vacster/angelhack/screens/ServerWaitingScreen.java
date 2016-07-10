package com.vacster.angelhack.screens;

import java.io.IOException;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.vacster.angelhack.Main;
import com.vacster.angelhack.helpers.KryoHelper;
import com.vacster.angelhack.helpers.Screens;

public class ServerWaitingScreen extends Group{

	private Label waitingLabel;
	
	public ServerWaitingScreen() {
		Main.server = new Server();
		try {
			Main.server.bind(Main.TCPport, Main.UDPport);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Main.server.start();
		KryoHelper.registerClasses(Main.server.getKryo());
		
		Main.server.addListener(new Listener(){
			@Override
			public void connected(Connection arg0) {
				Main.server.removeListener(this);//lol
				Main.changeScreen(Screens.SERVERGAMEROOM);
				super.connected(arg0);
			}
		});
		
		waitingLabel = new Label("WAITING FOR CONNECTIONS", Main.textureLoader.getSkin(), "small");
		waitingLabel.setPosition(Main.screenWidth/2 - waitingLabel.getWidth()/2, Main.screenHeight/2 + 200);
		addActor(waitingLabel);
	}
	
}
