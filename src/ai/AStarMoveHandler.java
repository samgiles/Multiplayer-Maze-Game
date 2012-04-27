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

public class AStarMoveHandler extends MoveHandler {
	Game game;
	
	AStarPathFinder finder;
	
	Iterator<MoveDirection> directions;
	
	public AStarMoveHandler(Game game) {
		this.game = game;
		reset();
	}
	
	public void reset() {
		finder = new AStarPathFinder(game.getMaze().getMaze());
		List<IMazeCell> result = finder.compute(game.getMaze().getMaze().getStartCell());
		
		List<MoveDirection> dirs = new ArrayList<MoveDirection>();
		
		for(int i = 0; i < result.size() - 2; i++) {
			dirs.add(MazeCellHelper.getDirectionBetween(result.get(i), result.get(i + 1)));
		}
		
		this.directions = dirs.iterator();
	}
	
	public void Update() {
		
		if (!directions.hasNext()) {
			return;
		}
		
		MoveDirection command = directions.next();
		
		this.notify(command);
	}
}
