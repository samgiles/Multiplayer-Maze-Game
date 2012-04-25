package tests.com.maze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.maze.IMazeCell;
import com.maze.MazeCellGrid;

import wlv.mazegenerator.CellGrid;
import wlv.mazegenerator.CellReference;

public class MazeCellGridTest {

	CellGrid grid;
	MazeCellGrid testObject;
	
	public MazeCellGridTest() {
		// grids are initialised with ALL walls ON in ALL directions.
		grid = new CellGrid();
		testObject = new MazeCellGrid(grid);
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSizeX() {
		// Default is 10x10 grid.
		assertTrue(testObject.getSizeX() == 10);
	}

	@Test
	public void testGetSizeY() {
		// Default is 10x10 grid.
		assertTrue(testObject.getSizeY() == 10);
	}

	@Test
	public void testGetMazeCell() {
		IMazeCell cell = testObject.getMazeCell(0, 1);
		assertTrue(cell.getX() == 0);
		assertTrue(cell.getY() == 1);
	}

	@Test
	public void testGetStartCell() {
		int x = grid.getStart().getY();
		int y = grid.getStart().getX();
		
		IMazeCell start = testObject.getStartCell();
		assertTrue(start.getX() == x);
		assertTrue(start.getY() == y);
	}


	@Test
	public void testGetEndCell() {
		int x = grid.getExit().getY();
		int y = grid.getExit().getX();
		
		IMazeCell end = testObject.getEndCell();
		assertTrue(end.getX() == x);
		assertTrue(end.getY() == y);
	}

}
