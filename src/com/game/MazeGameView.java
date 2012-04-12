package com.game;

import com.graphics.*;

import game.Game;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class MazeGameView extends View {
	
	private Game game;
	
	public MazeGameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		game = null;
	}
	
	public MazeGameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		game = null;
	}
	
	public MazeGameView(Context context) {
		super(context);
		game = null;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		IGraphicsContext context = new AndroidGraphicsContext(canvas);
		if (game != null) {
			game.draw(context);
		}
	}
}
