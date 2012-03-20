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
		IMazeGrid grid = MazeFactory.simpleGrid(mazeFileName, 200, 100);
		
		assertTrue(grid.getSizeX() == 100);
		assertTrue(grid.getSizeY() == 100);
		
		assertTrue(mazeFileExists());
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
