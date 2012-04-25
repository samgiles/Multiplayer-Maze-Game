package com.maze;

import com.MoveDirection;

public class MazeCellHelper {

	public static MoveDirection getDirectionBetween(IMazeCell a, IMazeCell b) {
		
		int xDiff = 0;
		if (a.getX() > b.getX()) {
			xDiff = -(a.getX() - b.getX());
		} else {
			xDiff = b.getX() - a.getX();
		}
		
		int yDiff = 0;
		
		if (a.getY() > b.getY()) {
			yDiff = -(a.getY() - b.getY());
		} else {
			yDiff = b.getY() - a .getY();
		}
		
		
		if (xDiff == 0 && yDiff == 1) {
			// UP
				return MoveDirection.UP;
		}
		
		if (xDiff == 0 && yDiff == -1) {
			// DOWN
				return MoveDirection.DOWN;
		}
		
		if (xDiff == -1 && yDiff == 0) {
				return MoveDirection.LEFT;
		}
		
		if (xDiff == 1 && yDiff == 0) {
				return MoveDirection.RIGHT;
		}
		return null;
	}
}
