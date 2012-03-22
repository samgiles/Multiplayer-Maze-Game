package wlv.mazegenerator;

/** Simple demo of the MazeGenerator class and Swing key bindings.
 * 
 *  YOUR TASKS:
 *    1) Read through the classes here. These will go into your Model.
 *    2) Start writing JUnit tests for the Cell, CellRef and CellGrid classes
 *       to help you understand them.
 *    3) Read through the links below and make sure you understand how
 *       Swing keybindings work to help you write your View.
 *  
 *  @author Sarah Mount, Gordon Branson.
 *  @date February 2012
 *  
 *  @see <a href="http://docs.oracle.com/javase/tutorial/uiswing/misc/keybinding.html">Key binding tutorial</a>
 *  @see <a href="http://java.sun.com/products/jfc/tsc/special_report/kestrel/keybindings.html">Tips on keybindings</a>
 */

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.JFrame;

import com.graphics.AWTGraphicsContext;

@SuppressWarnings("serial")
public class TestMazeGenerator extends javax.swing.JPanel {

	private MazeGenerator mazeGen;
	private CellGrid grid;
	private int row, col;
	private final int WIDTH = 640;
	private final int HEIGHT = 480;

	private InputMap mazeInputMap = new InputMap();
	private ActionMap mazeActionMap = new ActionMap();
	private Up up = new Up();
	private Down down = new Down();
	private Left left = new Left();
	private Right right = new Right();

	final class Left extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// do action when key 'Left' is pressed
			System.out.println("LEFT");
		}
	}

	final class Right extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// do action when key 'Right' is pressed
			System.out.println("RIGHT");
		}
	}

	final class Up extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// do action when key 'Up' is pressed
			System.out.println("UP");
		}
	}

	final class Down extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			// do action when key 'Down' is pressed
			System.out.println("DOWN");
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new TestMazeGenerator());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public TestMazeGenerator() {
		super();
		mazeGen = new MazeGenerator();
		grid = mazeGen.generateMaze("maze.jpg", WIDTH, HEIGHT);
		row = grid.getRow();
		col = grid.getCol();
		initGUI();
	}

	public TestMazeGenerator(int row, int col) {
		super();
		this.row = row;
		this.col = col;
		grid = mazeGen.generateMaze("maze.jpg", row, col);
		initGUI();
	}

	public TestMazeGenerator(int row, int col, CellGrid grid) {
		super();
		this.row = row;
		this.col = col;
		this.grid = grid;
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(grid.getSize());
		} catch (Exception e) {
			e.printStackTrace();
		}

		mazeInputMap = this.getInputMap(WHEN_IN_FOCUSED_WINDOW);
		mazeInputMap
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "Up");
		mazeInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false),
				"Down");
		mazeInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false),
				"Left");
		mazeInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false),
				"Right");

		mazeActionMap = this.getActionMap();
		mazeActionMap.put("Up", up);
		mazeActionMap.put("Down", down);
		mazeActionMap.put("Left", left);
		mazeActionMap.put("Right", right);

		this.setFocusable(true);
		this.requestFocus();
	}

	@Override
	public void update(Graphics g) {
		super.update(g);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		AWTGraphicsContext graphics = new AWTGraphicsContext(g);
		grid.draw2D(graphics);
	}

	public void updateGrid(CellGrid grid) {
		this.grid = grid;
	}

}
