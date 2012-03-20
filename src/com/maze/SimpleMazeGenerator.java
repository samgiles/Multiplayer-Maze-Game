package com.maze;

import uk.ac.wlv.mazegenerator.CellGrid;
import uk.ac.wlv.mazegenerator.MazeGenerator;

class SimpleMazeGenerator implements IMazeGenerator {
	
	private MazeGenerator mazeGenerator;
	
	public SimpleMazeGenerator() {
		mazeGenerator = new MazeGenerator();
	}

	/**
	 * Generates an IMazeGrid and writes the maze to the file specified by filename.
	 * @param filename String the filename to write the generated maze image.
	 * @param width int The width of the IMazeGrid
	 * @param height int The height of the IMazeGrid
	 * @return IMazeGrid The maze grid.
	 */
	@Override
	public IMazeGrid generateMaze(String filename, int width, int height) {
		CellGrid grid = mazeGenerator.generateMaze(filename, width, height);
		return new MazeCellGrid(grid);
	}
	
}