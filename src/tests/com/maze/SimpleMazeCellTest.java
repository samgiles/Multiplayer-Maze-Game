package tests.com.maze;

import static org.junit.Assert.*;

import org.junit.Test;

import wlv.mazegenerator.Cell;

import com.maze.*;


public class SimpleMazeCellTest {
	
	@Test
	public void testWallNorth() {
		Cell cell = new Cell();
		cell.setWallN(false);
		
		IMazeCell mazeCell = new MazeCell(cell, 0, 0);
		
		assertFalse("The cell was created with a northern wall, however the north wall was flagged as a non wall.", mazeCell.isWall(com.MoveDirection.UP));
	}
	
	@Test
	public void testIsWallEast() {
		Cell cell = new Cell();
		cell.setWallE(false);
		
		IMazeCell mazeCell = new MazeCell(cell, 0, 0);
		
		assertFalse("The cell was created with an eastern wall, however the east wall was flagged as a non wall.", mazeCell.isWall(com.MoveDirection.RIGHT));
	}
	
	@Test
	public void testIsWallSouth() {
		Cell cell = new Cell();
		cell.setWallS(false);
		
		IMazeCell mazeCell = new MazeCell(cell, 0, 0);
		
		assertFalse("The cell was created with a southern wall, however the south wall was flagged as a non wall.", mazeCell.isWall(com.MoveDirection.DOWN));	
	}
	
	@Test
	public void testIsWallWest() {
		Cell cell = new Cell();
		cell.setWallW(false);
		
		IMazeCell mazeCell = new MazeCell(cell, 0, 0);
		assertFalse("The cell was created with a western wall, however the west wall was flagged as a non wall.", mazeCell.isWall(com.MoveDirection.LEFT));
	}
	
}
