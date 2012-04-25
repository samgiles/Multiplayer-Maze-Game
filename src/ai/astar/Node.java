package ai.astar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;



public class Node<T> {
	public final Stack<Edge<T>> inEdges;
	public final PriorityQueue<Edge<T>> outEdges;
	
	public final T object;
	
	public Node(T object) {
		this.object = object;
		inEdges = new Stack<Edge<T>>();
		outEdges = new PriorityQueue<Edge<T>>();
	}
	
	public T getObject() {
		return this.object;
	}
	
	public Node<T> addEdge(Node<T> node) {
		Edge<T> e = new Edge<T>(this, node);
		outEdges.add(e);
		node.inEdges.push(e);
		return this;
	}
}
