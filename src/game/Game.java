package game;

import com.graphics.IGraphicsContext;

import entities.Entity;
import entities.EntityController;
import entities.MoveHandler;
import maze.MazeController;

public class Game {

	private MazeController maze;
	private EntityController playerA;
	private EntityController playerB;
	
	public Game(MazeController maze, MoveHandler moveHandler, Entity playerA, Entity playerB, boolean isAiEnemy) {
		this.playerA = new EntityController(playerA, moveHandler);
		
		// register AI Move handler
		if (isAiEnemy) {
			MoveHandler aiHandler = null;
			this.playerB = new EntityController(playerB, aiHandler);
		} else {
			this.playerB = new EntityController(playerB, moveHandler);
		}
		
		this.maze = maze;
	}
	
	public void draw(IGraphicsContext context) {
		maze.draw(context);
	}
}
