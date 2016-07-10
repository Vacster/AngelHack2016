package com.vacster.angelhack.helpers;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.vacster.angelhack.Main;

public class TextureStorage {

	private static Map<String, Texture> map;
	private static Skin skin;
	
	public TextureStorage() {
		map = new HashMap<String, Texture>();
		skin = new Skin(Gdx.files.internal("ui-gray.json"));
	}
	
	public Skin getSkin()
	{
		return skin;
	}
	
	public void addTexture(String str)
	{
		if(Main.textureLoader.getTexture("car") == null)
			map.put(str, new Texture(Gdx.files.internal(str+".png")));
	}
	
	public void removeTexture(String str)
	{
		map.get(str).dispose();
		map.remove(str);
	}
	
	public Texture getTexture(String str)
	{
		return map.get(str);
	}
	
}
