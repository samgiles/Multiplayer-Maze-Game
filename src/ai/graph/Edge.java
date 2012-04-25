package ai.graph;

import com.IDirection;

public class Edge<T> {
	
	private Node<T> to;

	private Node<T> from;
	
	private IDirection direction;
	
	private float weight;
	
	public Edge(Node<T> to, Node<T> from, IDirection direction, float weight) {
		this.to = to;
		this.from = from;
		this.direction = direction;
		this.weight = weight;
	}
	
	public Edge(Node<T> to, Node<T> from, IDirection direction) {
		this.to = to;
		this.from = from;
		this.direction = direction;
	}
	
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Node<T> getTo() {
		return to;
	}

	public Node<T> getFrom() {
		return from;
	}

	public IDirection getDirection() {
		return direction;
	}
}