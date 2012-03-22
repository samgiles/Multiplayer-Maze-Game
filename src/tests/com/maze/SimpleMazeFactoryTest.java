/**
 * 
 */
package tests.com.maze;


import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.maze.IMazeCell;
import com.maze.IMazeGrid;
import com.maze.MazeFactory;

/**
 * @author sam
 *
 */
public class SimpleMazeFactoryTest {

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
		
		IMazeGrid grid = MazeFactory.newSimpleGrid(mazeFileName, 200, 100);
		int x = grid.getSizeX();
		int y = grid.getSizeY();
		assertTrue("The X size of the grid was " + String.valueOf(x) + ", should have been 200", x == 200);
		assertTrue("The Y size of the grid was " + String.valueOf(y) + ", should have been 100", y == 100);
	}

	@Test
	public void testFileGeneration() {
		IMazeGrid grid = MazeFactory.newSimpleGrid(mazeFileName, 10, 10);
		assertTrue("The test file does not exist even after is has been created.", mazeFileExists());
		deleteMazeFile();
	}
	
	@Test
	public void testMazeGridCreation() {
		IMazeGrid grid = MazeFactory.newSimpleGrid(mazeFileName, 200, 100);
		IMazeCell cell = grid.getMazeCell(0, 0);
		// Should be able to assert that the cell is an IMazeCell;
		assertTrue("The returned value was not of instance IMazeCell", cell instanceof IMazeCell);
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
