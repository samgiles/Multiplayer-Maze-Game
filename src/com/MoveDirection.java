package com;

/**
 * Represents the direction of a game control.
 * @author Samuel Giles
 */
public enum MoveDirection implements IDirection {
	UP, DOWN, LEFT, RIGHT;
	
	public static MoveDirection convert(char direction) {
		switch (direction) {
			case 'n':
			case 'N':
				return UP;
			case 's':
			case 'S':
				return DOWN;
			case 'e':
			case 'E':
				return RIGHT;
			case 'w':
			case 'W':
				return LEFT;
		}
		return null;
	}

	@Override
	public IDirection getOpposite() {
		if (this == MoveDirection.UP) {
			return MoveDirection.DOWN;
		}
		
		if (this == MoveDirection.RIGHT) {
			return MoveDirection.LEFT;
		}
		
		if (this == MoveDirection.LEFT) {
			return MoveDirection.RIGHT;
		}
		
		if (this == MoveDirection.DOWN) {
			return MoveDirection.UP;
		}
		
		return null;
	}
}
