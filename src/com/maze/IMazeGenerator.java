package com.maze;


interface IMazeGenerator {

	/**
	 * Generates an IMazeGrid and writes the maze to the file specified by filename.
	 * @param filename String the filename to write the generated maze image.
	 * @param width int The width of the IMazeGrid
	 * @param height int The height of the IMazeGrid
	 * @return IMazeGrid The maze grid.
	 */
	public IMaze generateMaze(String filename, int width, int height);
}
