package ai.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.IDirection;

public class Node<T> {
	
	private HashMap<IDirection, Edge<T>> outEdges;
	private HashMap<IDirection, Edge<T>> inEdges;
	
	private boolean isRoot;
	
	private T nodeObject;
	
	public Node(T nodeObject, boolean isRoot) {
		this.nodeObject = nodeObject;
		this.isRoot = false;
		
		outEdges = new HashMap<IDirection, Edge<T>>();
		inEdges = new HashMap<IDirection, Edge<T>>();
	}
	
	public T getObject() {
		return nodeObject;
	}
	
	public boolean isRoot() {
		return isRoot;
	}
	
	public Map<IDirection, Edge<T>> getOutEdges() {
		return outEdges;
	}
	
	public Map<IDirection, Edge<T>> getInEdges() {
		return inEdges;
	}
	
	public void addNode(Node<T> node, IDirection direction) {
		outEdges.put(direction, new Edge<T>(node, this, direction));
		node.inEdges.put(direction.getOpposite(), new Edge<T>(this, node, direction.getOpposite()));
	}
	
	public String toString() {
		String returnString = "|\t(" + nodeObject.toString() + ")\n";
		for(Edge<T> e : outEdges.values()) {
			returnString += e.getTo().toString();
		}
		
		return returnString;
	}
}