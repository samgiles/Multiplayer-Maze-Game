package ai;

import java.util.*;

import maze.MazeController;

import ai.astar.Edge;
import ai.astar.Graph;
import ai.astar.Node;
import ai.ga.GAController;
import ai.graph.NodeGraphBuilder;

import com.MoveDirection;
import com.maze.IMaze;
import com.maze.IMazeCell;
import com.maze.MazeCellHelper;

import entities.MoveHandler;
import game.Game;

public class GeneticAlgorithmPathfinder extends MoveHandler {
	GAController geneticAlgorithm;
	
	Game game;
	
	List<MoveDirection> directions;
	Iterator<MoveDirection> iterator;
	
	MoveDirection lastCommand;
	
	
	public GeneticAlgorithmPathfinder(Game game) {
		this.game = game;
		reset();
	}
	
	public void reset() {
		geneticAlgorithm = new GAController(game.getMaze(), 0.5, 0.2, 190, 80, 100);
		geneticAlgorithm.run(10000);
		directions = geneticAlgorithm.getFittestGenome();
		directions.add(MoveDirection.UP);

		iterator = directions.iterator();
	}
	
	public void Update() {
		MoveDirection command = iterator.next();
		
		while(command == lastCommand) {
			command = iterator.next();
		}
		
		this.notify(command);
		lastCommand = command;
	}
}
