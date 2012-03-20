package com.maze;

import com.MoveDirection;

/**
 * Represents walls and free spaces in a Grid.
 * @author Samuel Giles
 */
public interface IMazeCell {

	/**
	 * Gets a boolean value determining if this cell is a wall in a particular dimension.
	 * @param direction MoveDirection The direction to test.
	 * @return boolean True if this cell is a wall in the specified direction, false if not.
	 */
	public boolean isWall(MoveDirection direction);
}
