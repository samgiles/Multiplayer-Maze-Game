package com;

/**
 * Represents the direction of a game control.
 * @author Samuel Giles
 */
public enum MoveDirection {
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
}
