package com.maze;

import uk.ac.wlv.mazegenerator.CellGrid;

class MazeCellGrid implements IMazeGrid {

	/**
	 * The underlying wlv.mazegenerator.CellGrid
	 */
	private CellGrid grid;
	
	/**
	 * Creates a new MazeCellGrid using the wlv.mazegenerator.CellGrid as it's underlying representation.
	 * @param grid
	 */
	public MazeCellGrid(CellGrid grid) {
		this.grid = grid;
	}
	
	/**
	 * Gets the X dimension of this IMazeGrid
	 * @return int
	 */
	@Override
	public int getSizeX() {
		return grid.getRow();
	}

	/**
	 * Gets the Y dimension of this IMazeGrid
	 * @return int
	 */
	@Override
	public int getSizeY() {
		return grid.getCol();
	}

	/**
	 * Gets the maze cell at a particular point on the grid.
	 * The parameters will be restricted to a value between 0 and the respective dimension's size.
	 * @param x int The x position to get the cell at.
	 * @param y int The y position to get the cell at.
	 * @return IMazeCell The cell.
	 */
	@Override
	public IMazeCell getMazeCell(int x, int y) throws IllegalArgumentException {
		if (x > getSizeX() || x < 0) {
			throw new IllegalArgumentException("Parameter X is not within range, must be greater than 0 and less than getSizeX()");
		}
		
		if (y > getSizeY() || y < 0) {
			throw new IllegalArgumentException("Parameter Y is not within range, must be greater than 0 and less than getSizeY()");
		}
		
		return new MazeCell(grid.getGrid()[x][y]);
	}

}
