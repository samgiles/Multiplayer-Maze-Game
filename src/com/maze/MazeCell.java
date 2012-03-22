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
class MazeCell implements IMazeCell {

	private final Cell cell;
	
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
