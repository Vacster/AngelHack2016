package com.vacster.angelhack;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;
import com.vacster.angelhack.helpers.Screens;
import com.vacster.angelhack.helpers.TextureStorage;
import com.vacster.angelhack.screens.*;

public class Main extends ApplicationAdapter{

	public static Stage stage;
	public static TextureStorage textureLoader;
	public static final int screenWidth = 1360, screenHeight = 720;
	public static int TCPport, UDPport;
	public static String IP;
	public static Server server;
	public static Client client;
	
	@Override
	public void create() {
		Log.set(Log.LEVEL_DEBUG);
		textureLoader = new TextureStorage();
		textureLoader.addTexture("car");//TODO Fix multithreading issue
		stage = new Stage(new FitViewport(1360, 720));
		Gdx.input.setInputProcessor(stage);
		changeScreen(Screens.MAINMENU);
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		stage.draw();
	}
	
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, false);
	}
	
	public static void changeScreen(Screens screen)
	{
		for(Actor act : stage.getActors())//Clears current actors before changing screen
			act.addAction(Actions.removeActor());
		
		switch(screen)
		{
		case CLIENTLOBBY:
			stage.addActor(new LobbyScreen(false));
			break;
		case SERVERLOBBY:
			stage.addActor(new LobbyScreen(true));
			break;
		default:
			try {
				stage.addActor(((Group) Class.forName(screen.getClassName()).newInstance()));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			break;
			
		}
	}

	public static void restartGame() {
		TCPport = -1;
		UDPport = -1;
		IP = null;
		
		server = null;
		client = null;
		changeScreen(Screens.MAINMENU);
	}
}
