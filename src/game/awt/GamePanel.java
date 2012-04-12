package game.awt;

import entities.Entity;
import game.Game;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.graphics.AWTGraphicsContext;
import com.graphics.IGraphicsContext;
import com.maze.IMaze;
import com.maze.MazeFactory;
import maze.MazeController;


public class GamePanel extends javax.swing.JPanel {

	
	private Game game;
	
	public static void main(String[] args) {
		final JFrame frame = new JFrame();
		IMaze imaze = MazeFactory.newSimpleGrid("maze.jpg", 20, 20);
		MazeController maze = new MazeController(imaze);
		
		AWTMoveHandler moveHandler = new AWTMoveHandler();
		
		moveHandler.listen(new entities.MovementListener(){

			@Override
			public void onMoveUp() {
				frame.paint(frame.getGraphics());
			}

			@Override
			public void onMoveDown() {
				frame.paint(frame.getGraphics());
			}

			@Override
			public void onMoveLeft() {
				frame.paint(frame.getGraphics());
			}

			@Override
			public void onMoveRight() {
				frame.paint(frame.getGraphics());
			}

		});
		
		frame.getContentPane().add(new GamePanel(new Game(maze, moveHandler, new Entity(), new Entity(), false)));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.addKeyListener(moveHandler);
		frame.pack();
		frame.setVisible(true);
	}
	
	public GamePanel(Game game) {
		this.game = game;
		this.setPreferredSize(new Dimension(400, 600));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		IGraphicsContext graphics = new AWTGraphicsContext(g);
		game.draw(graphics);
	}
	
}
