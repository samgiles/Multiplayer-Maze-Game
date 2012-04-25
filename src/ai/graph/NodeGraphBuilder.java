package ai.graph;

import com.MoveDirection;
import com.maze.IMazeCell;

import game.Game;

public class NodeGraphBuilder {
	
	private Game game;
	
	private Node<IMazeCell> rootNode;
	
	
	boolean goalFound = false;
	
	public NodeGraphBuilder(Game game) {
		this.game = game;
	}
	
	public Node<IMazeCell> buildGraph() {
		
		rootNode = new Node<IMazeCell>(game.getMaze().getStart(), true);
		
		buildEntireGraph(rootNode);

		return rootNode;
	}
	
	private void buildEntireGraph(Node<IMazeCell> node) {
		
		if (node.getObject().equals(game.getMaze().getMaze().getEndCell())) {
			goalFound = true;
			return;
		}
		
		int nX = node.getObject().getX();
		int nY = node.getObject().getY();
		
		if (!node.getObject().isWall(MoveDirection.UP) && !node.getOutEdges().containsKey(MoveDirection.UP)) 	{ node.addNode(new Node<IMazeCell>(game.getMaze().getMaze().getMazeCell(nX, nY + 1), false), MoveDirection.UP); }
		if (!node.getObject().isWall(MoveDirection.DOWN)  && !node.getOutEdges().containsKey(MoveDirection.DOWN)) 	{ node.addNode(new Node<IMazeCell>(game.getMaze().getMaze().getMazeCell(nX, nY - 1), false), MoveDirection.DOWN); }
		if (!node.getObject().isWall(MoveDirection.LEFT)  && !node.getOutEdges().containsKey(MoveDirection.LEFT)) 	{ node.addNode(new Node<IMazeCell>(game.getMaze().getMaze().getMazeCell(nX - 1, nY), false), MoveDirection.LEFT); }
		if (!node.getObject().isWall(MoveDirection.RIGHT)  && !node.getOutEdges().containsKey(MoveDirection.RIGHT)) 	{ node.addNode(new Node<IMazeCell>(game.getMaze().getMaze().getMazeCell(nX + 1, nY), false), MoveDirection.RIGHT); }
		
		// Depth first search.
		
		for (Edge<IMazeCell> e : node.getOutEdges().values()) {
			
			if (goalFound) {
				return;
			}
			
			buildEntireGraph(e.getTo());
		}
		
		return;
		
	}
	
}
