package com.sam.mazegenerator;

import java.util.Set;

import com.MoveDirection;
import com.graphics.IGraphicsContext;

public class Cell {
	
	public static final int CELL_SIZE = 30;
	
	private final int x;
	private final int y;
	
	char walls;
	
	
	public Cell(int x, int y, Set<MoveDirection> walls) {
		this.x = x;
		this.y = y;
		this.walls = 0;
		
		for(MoveDirection direction : walls) {
			setWall(direction);
		}
	}
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		setAllWalls();
	}
	
	public void setAllWalls() {
		walls = 0xF;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	/**
	 * Sets a wall given a direction in a cell.
	 * @param direction
	 */
	public void setWall(MoveDirection direction) {
		switch( direction) {
			case UP:
				walls |= 0x8;
			case RIGHT:
				walls |= 0x8 >> 1;
			case DOWN:
				walls |= 0x8 >> 2;
			case LEFT:
				walls |= 0x8 >> 3;
		}
	}
	
	public void clearWall(MoveDirection direction) {
		switch( direction) {
			case UP:
				walls &= ~0x8;
			case RIGHT:
				walls &= ~(0x8 >> 1);
			case DOWN:
				walls &= ~(0x8 >> 2);
			case LEFT:
				walls &= ~(0x8 >> 3);
		}
	}
	
	/**
	 * Get the wall value for this cell in a particular direction.
	 * @param direction The Direction to get the wall value for.
	 * @return boolean True if there is a wall in the specified direction.
	 */
	public boolean isWall(MoveDirection direction) {
		switch (direction) {
			case UP:
				return (walls & 0x8) != 0;
			case RIGHT:
				return (walls & (0x8 >> 1)) != 0;
			case DOWN:
				return (walls & (0x8 >> 2)) != 0;
			case LEFT:
				return (walls & (0x8 >> 3)) != 0;
 		}
		
		return false;
	}
	
	
	public void draw(IGraphicsContext g,int x, int y, int size) {
		if (isWall(MoveDirection.DOWN)) {
			g.drawLine(x, y + size, x + size, y + size);
			g.drawLine(x, y + size - 1, x + size, y + size - 1);
		}
		if (isWall(MoveDirection.UP)) {
			g.drawLine(x, y, x + size, y);
			g.drawLine(x, y + 1, x + size, y + 1);
		}
		if (isWall(MoveDirection.LEFT)) {
			g.drawLine(x, y, x, y + size);
			g.drawLine(x + 1, y, x + 1, y + size);
		}
		if (isWall(MoveDirection.RIGHT)) {
			g.drawLine(x + size, y, x + size, y + size);
			g.drawLine(x + size - 1, y, x + size - 1, y + size);
		}
	}
}
