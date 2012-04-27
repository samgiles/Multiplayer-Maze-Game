package tests.com.maze;

import static org.junit.Assert.*;

import org.junit.Test;

import wlv.mazegenerator.Cell;

import com.MoveDirection;
import com.maze.MazeCell;

public class MazeCellTest {

	MazeCell cellUnderTest;
	Cell cell;
	public MazeCellTest() {
		cell = new Cell(
				/* North has wall? */ true, 
				/* South has wall? */ true, 
				/* East has wall? */ false, 
				/* West has wall? */ true, 1);
		
		cellUnderTest = new MazeCell(cell, 7, 2);
	}
	
	@Test
	public void testIsWall() {
		assertTrue(cellUnderTest.isWall(MoveDirection.UP));
		assertTrue(cellUnderTest.isWall(MoveDirection.DOWN));
		assertTrue(cellUnderTest.isWall(MoveDirection.LEFT));
		assertFalse(cellUnderTest.isWall(MoveDirection.RIGHT));
		//cell.clearWall(MoveDirection.UP);
		cell.clearWall('n');
		assertFalse(cellUnderTest.isWall(MoveDirection.UP));
		
		//cell.setWall(MoveDirection.UP);
		cell.setWall('n');
		assertTrue(cellUnderTest.isWall(MoveDirection.UP));
		
		
		//cell.clearWall(MoveDirection.DOWN);
		cell.clearWall('s');
		assertFalse(cellUnderTest.isWall(MoveDirection.DOWN));
		
		//cell.setWall(MoveDirection.DOWN);
		cell.setWall('s');
		assertTrue(cellUnderTest.isWall(MoveDirection.DOWN));
		
		//cell.clearWall(MoveDirection.RIGHT);
		cell.clearWall('e');
		assertFalse(cellUnderTest.isWall(MoveDirection.RIGHT));
		
		//cell.setWall(MoveDirection.RIGHT);
		cell.setWall('e');
		assertTrue(cellUnderTest.isWall(MoveDirection.RIGHT));
		
		//cell.clearWall(MoveDirection.LEFT);
		cell.clearWall('w');
		assertFalse(cellUnderTest.isWall(MoveDirection.LEFT));
		
		//cell.setWall(MoveDirection.LEFT);
		cell.setWall('w');
		assertTrue(cellUnderTest.isWall(MoveDirection.LEFT));
	}

	@Test
	public void testGetX() {
		assertTrue(cellUnderTest.getX() == 7);
	}

	@Test
	public void testGetY() {
		assertTrue(cellUnderTest.getY() == 2);
	}

}
