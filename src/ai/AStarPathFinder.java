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
		return node.getY() == 9 && !node.isWall(MoveDirection.UP);
	}

	@Override
	protected double g(IMazeCell from, IMazeCell to) {
		
		if (from.getX() == to.getX() && from.getY() == to.getY()) {
			return 0.0;
		}
		
		MoveDirection direction = MazeCellHelper.getDirectionBetween(from, to);
		
		if (from.isWall(direction)) {
			return Double.MAX_VALUE;
		} else {
			return 1.0;
		}
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
		
		if (!node.isWall(MoveDirection.UP)) {
				ret.add(maze.getMazeCell(x, y + 1));
		}
		
		if (!node.isWall(MoveDirection.RIGHT)) {
				ret.add(maze.getMazeCell(x + 1, y));
		}
		
		if (!node.isWall(MoveDirection.DOWN)) {
				ret.add(maze.getMazeCell(x, y - 1));
		}
		
		if (!node.isWall(MoveDirection.LEFT)) {
				ret.add(maze.getMazeCell(x - 1, y));
		}
		
		return ret;
	}
	
}
