package com.game;

import maze.MazeController;

import com.maze.IMaze;
import com.maze.MazeFactory;

import entities.Entity;

import game.Game;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;

public class MazeGameActivity extends Activity {
	
	Game game;
	
	private final AndroidKeyMoveHandler moveHandler;
	
	public MazeGameActivity() {
		IMaze imaze = MazeFactory.newSimpleGrid("maze.jpg", 20, 20);
		MazeController maze = new MazeController(imaze);
		moveHandler = new AndroidKeyMoveHandler();
		game = new Game(maze, moveHandler, new Entity(), new Entity(), false);
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent ev) {
		moveHandler.keyPressed(ev);
		return true;
	}
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        MazeGameView v = (MazeGameView) findViewById(R.id.mazeGame); 
        v.setGame(this.game);
    }
    
    public Game getGame() {
    	return this.game;
    }
    
    
}