package game;

import store.DataSourceFactory;
import store.IDataSource;
import ai.AStarMoveHandler;
import ai.RandomWalkerMoveHandler;
import ai.astar.Graph;
import ai.astar.TreeVisualiser;

import com.graphics.IGraphicsContext;
import com.maze.IMaze;
import com.maze.MazeFactory;

import entities.Entity;
import entities.EntityController;
import entities.EntityLoader;
import entities.MoveHandler;
import maze.MazeController;

public class Game {

	private MazeController maze;
	private EntityController player;
	private EntityController ai;
	
	private EntityLoader entityLoader;
	
	private boolean drawMessage = false;
	private String message = "";
	MoveHandler aiHandler;
	
	public Game(MazeController maze, MoveHandler moveHandler, Entity entity) {
		this.maze = maze;
		this.player = new  EntityController(this, entity, moveHandler);
	}
	
	public Game(MoveHandler moveHandler, boolean isAiEnemy) {
		
		loadNewMaze();
		
		entityLoader = new EntityLoader();
		
		Entity player = entityLoader.getPlayerByName("player");
		
		if (player == null) {
			player = new Entity("player");
			entityLoader.savePlayer(player);
		}
		
		this.player = new EntityController(this, player, moveHandler);
		
		Entity ai = entityLoader.getPlayerByName("ai");
		
		if (ai == null) {
			ai = new Entity("ai");
			entityLoader.savePlayer(ai);
		}
		
		//aiHandler = new AStarMoveHandler(this); // temp
		aiHandler = new MoveHandler() {};
		// register AI Move handler
		this.ai = new EntityController(this, ai, aiHandler);
		
		
	}
	
	public MazeController getMaze() {
		return maze;
	}
	
	public void mazeCompleted(MazeController maze, EntityController entity) {
		if (entity == player) {
			message = "You Won!";
		} else if (entity == ai) {
			message = "You Lost!";
		}
		
		drawMessage = true;
		
		entityLoader.savePlayer(entity.getEntity());
		
		loadNewMaze();

		ai.resetPosition();
		player.resetPosition();
	}
	
	public void loadNewMaze() {
		IMaze imaze = MazeFactory.newSimpleGrid("maze.jpg", 100, 100);
		this.maze = new MazeController(imaze);
		
	}
	
	public void draw(IGraphicsContext context) {
		maze.draw(context);
		player.draw(context);
		ai.draw(context);
		
		if (drawMessage) {
			context.setColor(0, 0x99, 0xFF);
			context.fillRect(95, 130, 120, 30);
			context.setColor(0, 0, 0);
			context.drawText(message, 110, 150);
			drawMessage = false;
		}
	}
}
