/**
 * 
 */
package com.maze;

import wlv.mazegenerator.Cell;
import com.MoveDirection;

/**
 * Represents a MazeCell, this class is internal to the com.maze package, this facades the Cell implementation and transforms it into a IMazeCell interface.  You can only use it via it's interface IMazeCell
 * @see com.maze.IMazeCell
 * @author Samuel Giles
 * @version 0.1
 */
public class MazeCell implements IMazeCell {

	private final Cell cell;
	
	private final int x;
	private final int y;
	
	public MazeCell(Cell cell, int x, int y) {
		this.cell = cell;
		this.x = x;
		this.y = y;
	}

	/**
	 * @see com.maze.IMazeCell#isWall(com.MoveDirection)
	 */
	@Override
	public boolean isWall(MoveDirection direction) {
		boolean result = true;
		
		switch(direction) {
			case UP:
				result = cell.isWallN();
				break;
			case DOWN:
				result = cell.isWallS();
				break;
			case LEFT:
				result = cell.isWallW();
				break;
			case RIGHT:
				result = cell.isWallE();
		}
		
		return result;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object obj) {
		MazeCell cell = (MazeCell)obj;
		return cell.x == x && cell.y == y;
	}
	
	public String toString() {
		String returnString = "[" + this.x + ", " + this.y + "] - Free Spaces: ";
		
		if (!isWall(MoveDirection.UP)) {
			returnString += " UP ";
		}
		
		if (!isWall(MoveDirection.DOWN)) {
			returnString += " DOWN ";
		}
		
		if (!isWall(MoveDirection.LEFT)) {
			returnString += " LEFT ";
		}
		
		if (!isWall(MoveDirection.RIGHT)) {
			returnString += " RIGHT ";
		}
		
		return returnString;
	}
}
