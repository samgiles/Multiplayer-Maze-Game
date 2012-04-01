package com.maze;

import wlv.mazegenerator.Cell;
import wlv.mazegenerator.CellGrid;
import wlv.mazegenerator.CellRef;

/**
 * An implementation of an IMazeGrid that facades the wlv version of CellGrid.  This is internal and can only be used via it's interface.
 * @author Samuel Giles
 * @version 0.1
 */
class MazeCellGrid implements IMazeGrid {

	/**
	 * The underlying wlv.mazegenerator.CellGrid
	 */
	protected final CellGrid grid;
	
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

	@Override
	public IMazeCell getStartCell() {
		CellRef ref = this.grid.getStart();
		return getMazeCell(ref.getRow(), ref.getCol());
	}
	
	@Override
	public IMazeCell getEndCell() {
		CellRef ref = this.grid.getExit();
		return getMazeCell(ref.getRow(), ref.getCol());
	}

}
