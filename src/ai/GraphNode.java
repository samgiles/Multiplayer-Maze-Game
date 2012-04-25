package ai;

import java.util.LinkedHashSet;
import java.util.Set;

import com.MoveDirection;
import com.maze.IMaze;
import com.maze.IMazeCell;

public class GraphNode {
	GraphNode parent;
	IMazeCell mazeCell;
	
	MoveDirection parentDirection;
	
	Set<GraphNode> adjacencies;
	
	IMaze maze;
	
	public GraphNode(IMazeCell mazeCell, IMaze maze, GraphNode parent, MoveDirection direction) {
		this.mazeCell = mazeCell;
		this.parent = parent;
		parentDirection = direction;
		adjacencies = new LinkedHashSet<GraphNode>();
		this.maze = maze;
	}
	
	public void init(IMazeCell target){
		
		if (mazeCell == target) {
			return;
		}
		
		boolean north = !mazeCell.isWall(MoveDirection.UP) && !(parentDirection == MoveDirection.DOWN);
		boolean east = !mazeCell.isWall(MoveDirection.RIGHT) && !(parentDirection == MoveDirection.LEFT);
		boolean south = !mazeCell.isWall(MoveDirection.DOWN) && !(parentDirection == MoveDirection.UP);
		boolean west = !mazeCell.isWall(MoveDirection.LEFT) && !(parentDirection == MoveDirection.RIGHT);
		
		if (north) { 
			try {
				addNode(maze.getMazeCell(mazeCell.getX(), mazeCell.getY() + 1), MoveDirection.UP, target);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
		if (east) { 
			try {
				addNode(maze.getMazeCell(mazeCell.getX() + 1, mazeCell.getY()), MoveDirection.RIGHT, target);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
		if (south) { 
			try {
				addNode(maze.getMazeCell(mazeCell.getX(), mazeCell.getY() - 1), MoveDirection.DOWN, target);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
		if (west) {
			try {
				addNode(maze.getMazeCell(mazeCell.getX() - 1, mazeCell.getY()), MoveDirection.LEFT, target);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void addNode(IMazeCell cell, MoveDirection parentDirection, IMazeCell target) {
		GraphNode node = new GraphNode(cell, maze, this, parentDirection);
		node.init(target);
		adjacencies.add(node);
	}
}
