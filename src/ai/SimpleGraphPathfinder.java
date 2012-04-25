package ai;

import java.util.*;

import ai.astar.Edge;
import ai.astar.Graph;
import ai.astar.Node;
import ai.graph.NodeGraphBuilder;

import com.MoveDirection;
import com.maze.IMaze;
import com.maze.IMazeCell;
import com.maze.MazeCellHelper;

import entities.MoveHandler;
import game.Game;

public class SimpleGraphPathfinder extends MoveHandler {
	Graph graph;
	Iterator<MoveDirection> directions;
	Game game;
	
	NodeGraphBuilder graphBuilder;

	public SimpleGraphPathfinder(Game game) {
		this.game = game;
		reset();
	}
	
	public void reset() {
		init();
	}
	
	private void init() {
		graphBuilder = new NodeGraphBuilder(game);
		ai.graph.Node<IMazeCell> rootNode = graphBuilder.buildGraph();
		System.out.print(rootNode);
	}
	
	public void Update() {
	}
}
