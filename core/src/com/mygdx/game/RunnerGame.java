package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.screens.GameScreen;

public class RunnerGame extends Game
{
	@Override
	public void create ()
	{
		setScreen(new GameScreen());
	}

}
