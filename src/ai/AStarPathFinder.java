package ai;

import java.util.LinkedList;
import java.util.List;

import com.MoveDirection;
import com.maze.*;

import ai.astar.AStar;

public class AStarPathFinder extends AStar<IMazeCell> {

	private IMaze maze;
	
	public AStarPathFinder(IMaze maze) {
		this.maze = maze;
	}
	
	
	@Override
	protected boolean isGoal(IMazeCell node) {
		return node.getX() == maze.getEndCell().getX() && node.getY() == maze.getEndCell().getY();
	}

	@Override
	protected double g(IMazeCell from, IMazeCell to) {
		if (from.getX() == to.getX() && from.getY() == to.getY()) {
			return 0.0;
		}
		int xDiff = 0;
		int yDiff = 0;
		try {
			xDiff = from.getX() - to.getX();
			yDiff = from.getY() - to.getY();
		} catch (IllegalArgumentException e) {
			return Double.MAX_VALUE;
		}
		
		if (xDiff == 0 && yDiff == -1) {
			// UP
			if (from.isWall(MoveDirection.UP)) {
				return Double.MAX_VALUE;
			} else {
				return 1.0;
			}
		}
		
		if (xDiff == 0 && yDiff == 1) {
			// DOWN
			if (from.isWall(MoveDirection.DOWN)) {
				return Double.MAX_VALUE;
			} else {
				return 1.0;
			}
		}
		
		if (xDiff == -1 && yDiff == 0) {
			if (from.isWall(MoveDirection.LEFT)) {
				return Double.MAX_VALUE;
			} else {
				return 1.0;
			}
		}
		
		if (xDiff == 1 && yDiff == 0) {
			if (from.isWall(MoveDirection.RIGHT)) {
				return Double.MAX_VALUE;
			} else {
				return 1.0;
			}
		}
		
		return Double.MAX_VALUE;
	}

	@Override
	protected double h(IMazeCell from, IMazeCell to) {
		double val = (Math.abs(to.getX() - 1 - maze.getEndCell().getX()) + Math.abs(to.getY() - 1 - maze.getEndCell().getY()));

		return val;
	}

	@Override
	protected List<IMazeCell> generateSuccessors(IMazeCell node) {
		List<IMazeCell> ret = new LinkedList<IMazeCell>();
		int x = node.getX();
		int y = node.getY();
		
		if (node.isWall(MoveDirection.UP) == false) {
			if ( y < maze.getSizeY() - 1) { 
				ret.add(maze.getMazeCell(x, y + 1));
			}
		}
		
		if (node.isWall(MoveDirection.RIGHT) == false) {
			if ( x != 0 ) {
				ret.add(maze.getMazeCell(x - 1, y));
			}
		}
		
		if (node.isWall(MoveDirection.DOWN) == false) {
			if ( y != 0 ) {  // TODO Strange bug here, this just filters it.
				ret.add(maze.getMazeCell(x, y - 1));
			}
		}
		
		if (node.isWall(MoveDirection.LEFT) == false) {
			if ( x < maze.getSizeX() - 1 ) {
				ret.add(maze.getMazeCell(x + 1, y));
			}
		}
		
		return ret;
	}
	
}
