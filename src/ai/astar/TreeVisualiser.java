package ai.astar;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import maze.MazeController;

import com.maze.IMaze;
import com.maze.IMazeCell;
import com.maze.MazeFactory;

public class TreeVisualiser extends JPanel {
	
	
	public static void main(String args[]) {
		IMaze imaze = MazeFactory.newSimpleGrid("maze.jpg", 100, 100);
		Graph testGraph = new Graph(imaze);
		TreeVisualiser v = new TreeVisualiser(testGraph);
	}
	
	
	Graph graph;
	
	public TreeVisualiser(Graph graph) {
		this.graph = graph;
		JFrame container = new JFrame("Tree Visualiser");
		container.add(this);
		container.setSize(new Dimension(500, 600));
		container.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		container.setVisible(true);
		container.paintComponents(container.getGraphics());
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("Beginning Draw");
		g.drawString("TEST", 10, 10);
		drawTree(g, graph.getRoot(), 1);
	}
	
	public void drawTree(Graphics g, Node<IMazeCell> node, int depth) {
		for (int i = 0; i < node.outEdges.size(); i++) {
			drawLines(g, 100, depth + 10, node.outEdges.size());
			
			for(Edge<IMazeCell> e : node.outEdges) {
				drawTree(g, e.to, depth + 1);
			}
			
		}
	}
	
	public void drawLines(Graphics g, int x, int y, int number) {
		for (int i = 0; i < number; i++) {
			g.drawLine(x, y, (number + i) * 100, i + 100);
		}
	}
}
