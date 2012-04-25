package ai.astar;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import com.maze.IMazeCell;


public abstract class AStar<T> {

	private class Path implements Comparable {
		public T point;
		
		public Double f;
		public Double g;
		
		public Path parent;
		
		public Path() {
			parent = null;
			point = null;
			g = 0.0;
			f = 0.0;
		}
		
		public Path(Path p) {
			this();
			parent = p;
			g = p.g;
			f = p.f;
		}
		
		
		
		@Override
		public int compareTo(Object arg0) {
			Path p = (Path) arg0;
			return (int)(f - p.f);
		}
		
		public T getPoint() {
			return point;
		}
		
		public void setPoint(T point) {
			this.point = point;
		}
		
	}
	
	protected abstract boolean isGoal(T node);
	
	protected abstract double g(T from, T to);
	
	protected abstract double h(T from, T to);
	
	protected abstract List<T> generateSuccessors(T node);
	
	private PriorityQueue<Path> paths;
	private HashMap<T, Double> minDists;
	private double lastCost;
	private int expandedCounter;
	
	public int getExpandedCounter() {
		return expandedCounter;
	}
	
	public AStar() {
		paths = new PriorityQueue<Path>();
		minDists = new HashMap<T, Double>();
		expandedCounter =0 ;
		lastCost = 0.0;
	}
	
	protected double f(Path p, T from, T to) {
		double g = g(from, to) + ((p.parent != null) ? p.parent.g : 0.0);
		double h = h(from, to);
		
		p.g = g;
		p.f = g + h;
		
		return p.f;
	}
	
	private void expand(Path path) {
		T p = path.getPoint();
		Double min = minDists.get(path.getPoint());
		
		if ((min == null) || min.doubleValue() > path.f.doubleValue()) {
			minDists.put(path.getPoint(), path.f);
		} else {
			return;
		}
		
		List<T> successors = generateSuccessors(p);
		
		for (T t : successors) {
			Path newPath = new Path(path);
			newPath.setPoint(t);
			f(newPath, path.getPoint(), t);
			paths.offer(newPath);
		}
		
		expandedCounter++;
	}
	
	public double getCost() {
		return lastCost;
	}
	
	public List<T> compute(T start) {
		try {
			Path root = new Path();
			root.setPoint(start);
			System.out.println("Set start: (" + ((IMazeCell)start).getX() + "," + ((IMazeCell)start).getY() + ")");
			f(root, start, start);
			
			expand(root);
			
			for(;;) {
				Path p = paths.poll();
				
				debugPrint(p);
				
				if (p == null) {
					lastCost = Double.MAX_VALUE;
					return null;
				}
				
				T last = p.getPoint();
				lastCost = p.g;
				
				if (isGoal(last)) {
					LinkedList<T> retPath = new LinkedList<T>();
					
					for (Path i = p; i != null; i = i.parent) {
						retPath.addFirst(i.getPoint());
					}
					
					return retPath;
				}
				
				expand(p);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Traverses a path and outputs the information to the stdout.
	 * @param p
	 */
	private static void debugPrint(final AStar.Path p) {
		int i = 1;
		AStar.Path path = p;
		System.out.println();
		while (path != null && path.parent != null) {
			System.out.println(i + ": " + ((IMazeCell)path.point).getX() + "," + ((IMazeCell)path.point).getY());
			path = path.parent;
			i++;
		}
	}
}
