package tests.com.maze;

import static org.junit.Assert.*;

import org.junit.Test;

import com.maze.*;


public class SimpleMazeCellTest {
	
	@Test
	public void testIsWallNorth() {
		IMazeCell mazeCell = new MockMazeCell(true, false, false, false);
		assertTrue("The cell was created with a northern wall, however the north wall was flagged as a non wall.", mazeCell.isWall(com.MoveDirection.UP));
	}
	
	@Test
	public void testIsWallEast() {
		IMazeCell mazeCell = new MockMazeCell(false, true, false, false);
		assertTrue("The cell was created with an eastern wall, however the east wall was flagged as a non wall.", mazeCell.isWall(com.MoveDirection.RIGHT));
	}
	
	@Test
	public void testIsWallSouth() {
		IMazeCell mazeCell = new MockMazeCell(false, false, true, false);
		assertTrue("The cell was created with a southern wall, however the south wall was flagged as a non wall.", mazeCell.isWall(com.MoveDirection.DOWN));	
	}
	
	@Test
	public void testIsWallWest() {
		IMazeCell mazeCell = new MockMazeCell(false, false, false, true);
		assertTrue("The cell was created with a western wall, however the west wall was flagged as a non wall.", mazeCell.isWall(com.MoveDirection.LEFT));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDirection() {
		IMazeCell mazeCell = new MockMazeCell(false, false, false, true);
		mazeCell.isWall(com.MoveDirection.valueOf("Invalid")); // Should trigger an exception	
	}
	
}
