/**
 * 
 */
package tests.com.maze;


import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.maze.IMazeGrid;
import com.maze.MazeFactory;

/**
 * @author sam
 *
 */
public class MazeFactoryTest {

	private final String mazeFileName = "test.maze.jpg";
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Make sure the file does not exist already.
		
		if (mazeFileExists()) {
			deleteMazeFile();
		}
	}
	
	@Test
	public void testSimpleGridCreator() {
		
		// This simply doesn't do as expected due to something in WLV's implementation...
		
		IMazeGrid grid = MazeFactory.simpleGrid(mazeFileName, 200, 100);
		int x = grid.getSizeX();
		int y = grid.getSizeY();
		assertTrue("The X size of the grid was " + String.valueOf(x) + ", should have been 200", x == 200);
		assertTrue("The Y size of the grid was " + String.valueOf(y) + ", should have been 100", y == 100);
	}

	@Test
	public void testFileGeneration() {
		IMazeGrid grid = MazeFactory.simpleGrid(mazeFileName, 10, 10);
		assertTrue(mazeFileExists());
		deleteMazeFile();
	}
	
	private boolean mazeFileExists() {
		File file = new File(mazeFileName);
		return file.exists();
	}
	
	private boolean deleteMazeFile() {
		File file = new File(mazeFileName);
		return file.delete();
	}

}
