/**
 * 
 */
package com.maze;

/**
 * @author sam
 *
 */
public class MazeFactory {

	private static IMazeGenerator generator = null;
	
	public static IMazeGrid simpleGrid(String saveTo, int width, int height) {
			generator = new SimpleMazeGenerator();
			return generator.generateMaze(saveTo, width, height);
	}
}
