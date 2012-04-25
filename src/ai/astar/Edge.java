package ai.astar;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

import com.maze.IMazeCell;

public class Edge<T> implements Comparable<T> {
	public final Node<T> from;
	public final Node<T> to;
	
	private float weight;
	
	public Edge(Node<T> from, Node<T> to) {
		this.from = from;
		this.to = to;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public Node<T> getStart() {
		return from;
	}
	
	public Node<T> getEnd() {
		return to;
	}
	
	public boolean equals(Object o) {
		Edge<T> e = (Edge<T>)o;
		return e.from == from && e.to == to;
	}
	
	public static <T> void setWeights(Stack<Edge<T>> edges, float weight) {
		Iterator<Edge<T>> it = edges.iterator();
		
		while(it.hasNext()) {
			Edge<?> e = it.next();
			e.setWeight(weight);
		}
	}

	@Override
	public int compareTo(Object arg0) {
		Edge<IMazeCell> e = (Edge<IMazeCell>)arg0;
		return (int) (weight - e.weight);
	}
}
