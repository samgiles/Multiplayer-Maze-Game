package game.awt;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.graphics.AWTGraphicsContext;
import com.graphics.IGraphicsContext;
import com.maze.IMaze;
import com.maze.MazeFactory;
import maze.MazeController;


public class GamePanel extends javax.swing.JPanel {

	
	private MazeController maze;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		IMaze imaze = MazeFactory.newSimpleGrid("maze.jpg", 20, 20);
		MazeController maze = new MazeController(imaze);
		
		frame.getContentPane().add(new GamePanel(maze));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public GamePanel(MazeController maze) {
		this.maze = maze;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		IGraphicsContext graphics = new AWTGraphicsContext(g);
		maze.draw(graphics);
	}
	
}
