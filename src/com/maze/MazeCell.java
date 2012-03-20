/**
 * 
 */
package com.maze;

import wlv.mazegenerator.Cell;

import com.MoveDirection;

/**
 * @author Samuel Giles
 *
 */
public class MazeCell implements IMazeCell {

	private Cell cell;
	
	public MazeCell(Cell cell) {
		this.cell = cell;
	}
	
	/**
	 * @see com.maze.IMazeCell#isWall(com.MoveDirection)
	 */
	@Override
	public boolean isWall(MoveDirection direction) {
		switch(direction) {
			case UP:
				return cell.isWallN();
			case DOWN:
				return cell.isWallS();
			case LEFT:
				return cell.isWallW();
			case RIGHT:
				return cell.isWallE();
			default:
				throw new IllegalArgumentException("Invalid direction given: " + direction.toString());
		}
	}

}
