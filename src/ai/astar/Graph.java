package ai.astar;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.MoveDirection;
import com.maze.*;


public class Graph {
	
	private final IMaze maze;
	
	private Node<IMazeCell> root;
	
	private HashSet<IMazeCell> visited;
	
	boolean hitresult = false;
	
	private Stack<MoveDirection> directions = new Stack<MoveDirection>();
	
	public Graph(IMaze maze) {
		root = new Node<IMazeCell>(maze.getStartCell());
		this.maze = maze;
		
		visited = new HashSet<IMazeCell>();
		buildGraph(root);
	}
	
	public Stack<MoveDirection> getDirections() {
		return directions;
	}
	
	public Node<IMazeCell> getRoot() {
		return root;
	}
	
	private void traverseEdges(Node<IMazeCell> node, int weight) {
		
		Iterator<Edge<IMazeCell>> it = node.inEdges.iterator();
	
		while(it.hasNext()) {
			Edge<IMazeCell> e = it.next();
			e.setWeight(weight + 1);
			traverseEdges(e.from, weight + 1);
		}
	}
	
	private void traverseFromGoal(Node<IMazeCell> node) {
		Iterator<Edge<IMazeCell>> it = node.inEdges.iterator();
		while(it.hasNext()) {
			Edge<IMazeCell> e = it.next();
			directions.push(MazeCellHelper.getDirectionBetween(e.from.getObject(), e.to.getObject()));
			traverseFromGoal(e.from);
		}
	}
	
	private void buildGraph(Node<IMazeCell> node) {
		List<IMazeCell> adjacencies = getAdjacencies(node.getObject());
		HashSet<IMazeCell> visited = new HashSet<IMazeCell>();
		for (IMazeCell c : adjacencies) {
			
			if (node.inEdges.contains(c) || visited.contains(c)) {
				continue;
			}
			
			visited.add(c);
			
			Node<IMazeCell> n = new Node<IMazeCell>(c);
			
			if (n.getObject().getX() == maze.getEndCell().getX() && n.getObject().getY() == maze.getEndCell().getY()) {
				hitresult = true;
				traverseFromGoal(node);
				return;
			}
			
			node.addEdge(n);
			buildGraph(n);
			if (hitresult) {
				return;
			}
		}
		
		int weight = 10;
		
		
		
		Edge.setWeights(node.inEdges, weight);
		
		this.traverseEdges(node, weight);
	}
	
	private List<IMazeCell> getAdjacencies(IMazeCell cell) {
		List<IMazeCell> adjacencies = new LinkedList<IMazeCell>();
		
		int x = cell.getX();
		int y = cell.getY();
		
		if (cell.isWall(MoveDirection.UP) == false) {
			// Get Cell above this.
			try {
				adjacencies.add(maze.getMazeCell(x, y + 1));
			} catch (Exception e) {
			}
		}
		
		if (cell.isWall(MoveDirection.RIGHT) == false) {
			// Get Cell to the right of this cell.
			try {
				adjacencies.add(maze.getMazeCell(x + 1, y));
			} catch (Exception e) {
			}
		}
		
		if (cell.isWall(MoveDirection.DOWN) == false) {
			// Get Cell above this.
			try{
				adjacencies.add(maze.getMazeCell(x, y - 1));
			} catch (Exception e) {
			}
		}
		
		if (cell.isWall(MoveDirection.LEFT) == false) {
			// Get Cell to the right of this cell.
			try {
				adjacencies.add(maze.getMazeCell(x - 1, y));
			} catch (Exception e) {
			}
		}
		
		return adjacencies;
	}
}
