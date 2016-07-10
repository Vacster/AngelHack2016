package com.vacster.angelhack.helpers;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.vacster.angelhack.Main;

public class ScreenButton extends ClickListener{

	private Screens screen;
	
	public ScreenButton(Screens screen) {
		this.screen = screen;
	}
	
	@Override
	public void clicked(InputEvent event, float x, float y) {
		Main.changeScreen(screen);
		super.clicked(event, x, y);
	}
	
}
