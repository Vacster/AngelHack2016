package com.vacster.angelhack.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.vacster.angelhack.Main;
import com.vacster.angelhack.packets.RotationPacket;

public class ClientGameScreen extends Group{

	public ClientGameScreen() {
		Gdx.app.log("Debug", "Client Game Screen");
	}
	
	@Override
	public void act(float delta) {
		Main.client.sendUDP(new RotationPacket(Gdx.input.getAccelerometerY(), Gdx.input.getAccelerometerZ()/250f));
		super.act(delta);
	}
	
}
