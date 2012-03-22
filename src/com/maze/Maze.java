/**
 * 
 */
package com.maze;

import wlv.mazegenerator.CellGrid;

import com.graphics.IGraphicsContext;

/**
 * Represents a maze.
 * @author Samuel Giles
 */
class Maze extends MazeCellGrid implements IMaze{

	public Maze(CellGrid grid) {
		super(grid);
	}

	@Override
	public void draw(IGraphicsContext g) {
		this.grid.draw2D(g);
	}

}
