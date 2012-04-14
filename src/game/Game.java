package game;

import ai.RandomWalkerMoveHandler;

import com.graphics.IGraphicsContext;

import entities.Entity;
import entities.EntityController;
import entities.MoveHandler;
import maze.MazeController;

public class Game {

	private MazeController maze;
	private EntityController playerA;
	private EntityController playerB;
	
	private RandomWalkerMoveHandler aiHandler = null;
	
	public Game(MazeController maze, MoveHandler moveHandler, Entity playerA, Entity playerB, boolean isAiEnemy) {
		this.playerA = new EntityController(playerA, moveHandler, maze);
		
		// register AI Move handler
		if (isAiEnemy) {
			aiHandler = new RandomWalkerMoveHandler();
			this.playerB = new EntityController(playerB, aiHandler, maze);
		} else {
			this.playerB = new EntityController(playerB, moveHandler, maze);
		}
		
		this.maze = maze;
	}
	
	public void draw(IGraphicsContext context) {
		aiHandler.Update(0);
		maze.draw(context);
		playerA.draw(context);
		playerB.draw(context);
	}
}
