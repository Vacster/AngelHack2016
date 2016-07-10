package com.vacster.angelhack.screens;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.vacster.angelhack.Main;
import com.vacster.angelhack.packets.RotationPacket;

public class ServerGameScreen extends Group{

	private Image car;
	private final int width = 50, height = 80;
	private float velocity = 0, rotation = 0;
	
	public ServerGameScreen() {
		car = new Image(Main.textureLoader.getTexture("car"));
		car.setBounds(Main.screenWidth/2 - width/2, Main.screenHeight/2 - height/2, width, height);
		car.setOrigin(Align.center);
		addActor(car);
		
		Main.server.addListener(new Listener(){
			@Override
			public void disconnected(Connection arg0) {
				Main.restartGame();
				super.disconnected(arg0);
			}
			
			@Override
			public void received(Connection arg0, Object obj) {
				if(obj instanceof RotationPacket)
				{
					RotationPacket p = (RotationPacket)obj;
					velocity += p.acc;
					rotation = p.rotation;
					if(velocity < 0)
						velocity = 0;
					else if(velocity  >= 6)
						velocity = 6;
				}
				super.received(arg0, obj);
			}
		});
	}
	
	@Override
	public void act(float delta) {
		car.rotateBy(-velocity*rotation/12f);
		car.moveBy(velocity * MathUtils.sinDeg(-car.getRotation()), velocity * MathUtils.cosDeg(car.getRotation()));
		super.act(delta);
	}
}
