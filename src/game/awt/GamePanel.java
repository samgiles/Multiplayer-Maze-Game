package game.awt;

import entities.Entity;
import game.Game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import com.graphics.AWTGraphicsContext;
import com.graphics.IGraphicsContext;
import com.maze.IMaze;
import com.maze.MazeFactory;
import maze.MazeController;


public class GamePanel extends javax.swing.JPanel {

	private Game game;
	
	public static void showPanel() {
		final JFrame frame = new JFrame();
		
		
		AWTMoveHandler moveHandler = new AWTMoveHandler();	
		frame.getContentPane().add(new GamePanel(new Game(moveHandler, false)));
		// At the moment the order of the draw is important, as it is tied into the moveListener...
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
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to quit?",
                            "Exiting game, are you sure?",
                            JOptionPane.YES_NO_OPTION) != 1) {
					
						MainMenu.showMenu();
						frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						frame.setVisible(false);
						frame.removeAll();
					}
					
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.addKeyListener(moveHandler);
		frame.pack();
		frame.setVisible(true);
	}
	
	public GamePanel(Game game) {
		this.game = game;
		this.setPreferredSize(new Dimension(300, 300));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		IGraphicsContext graphics = new AWTGraphicsContext(g);
		game.draw(graphics);
	}
	
}
