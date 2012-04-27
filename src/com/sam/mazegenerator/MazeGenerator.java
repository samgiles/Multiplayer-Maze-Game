package com.sam.mazegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.MoveDirection;
import com.graphics.IGraphicsContext;

public class MazeGenerator {
	
	LinkedList<Cell> cellListC;
	int xDimension;
	int yDimension;
	Cell[][] grid;
	
	MoveDirection[] dirs = { MoveDirection.UP, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.DOWN };
	
	
	public MazeGenerator(int xDimension, int yDimension) {
		cellListC = new LinkedList<Cell>();
		
		this.xDimension = xDimension;
		this.yDimension = yDimension;
		
		for (int x = 0; x < xDimension; x++) {
			for (int y = 0; y < yDimension; y++) {
				cellListC.add(new Cell(x, y));
			}
		}
		
		grid = new Cell[xDimension][yDimension];
		generate();
	}
	
	private int getRand(int max) {
		return (int) (Math.random() * max);
	}
	
	private void generate() {
		
		int randomStartPosition = getRand(xDimension);
		
		// Set starting position and add to list C.
		grid[randomStartPosition][0] = cellListC.remove(randomStartPosition * xDimension);
		cellListC.addLast(grid[randomStartPosition][0]);
		
		while (!cellListC.isEmpty()) {
			
			int index = nextIndex();
			
			Cell cell = cellListC.get(index);
			
			List<MoveDirection> shuffledDirs = Arrays.asList(dirs);
			Collections.shuffle(shuffledDirs);
			
			for(MoveDirection dir : shuffledDirs) {
				
				int newX = cell.getX();
				int newY = cell.getY();
				
				switch (dir) {
					case UP:
						newY += 1;
						break;
					case RIGHT:
						newX += 1;
					case DOWN:
						newY -= 1;
						break;
					case LEFT:
						newX -= 1;
						break;
				}
				
				if (newX >= 0 && newY >= 0 && newX < xDimension && newY < yDimension && grid[newX][newY] == null) {
					
					if (grid[cell.getX()][cell.getY()] == null) {
						grid[cell.getX()][cell.getY()] = cell;
					}
					
					grid[cell.getX()][cell.getY()].clearWall(dir);
					
					grid[newX][newY] = new Cell(newX, newY);
					grid[newX][newY].clearWall((MoveDirection)dir.getOpposite());
					
					System.out.println("(" + cell.getX() + ", " + cell.getY() + ")" + "-> " + dir + " -> (" + newX + ", " + newY + ")");
					
					
					cellListC.add(grid[newX][newY]);
					break;
				}
			}
			cellListC.remove(index);
		}
		
	}
	
	private int nextIndex() {
		return cellListC.size() -1; // Newest
	}
	
	public void draw(IGraphicsContext g) {
		for(int x = 0; x < xDimension; x++) {
			for (int y = 0; y < yDimension; y++) {
				if (grid[x][y] == null) {
					grid[x][y] = new Cell(x,y);
				}
				
				grid[x][y].draw(g, x + (x * Cell.CELL_SIZE), (y + (yDimension * Cell.CELL_SIZE)) - (y * Cell.CELL_SIZE), Cell.CELL_SIZE);
			}
		}
	}
}