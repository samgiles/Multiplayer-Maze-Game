/**
 * 
 */
package com.maze;

/**
 * @author sam
 *
 */
public class MazeFactory {

	
	private static MazeFactory factory = null;
	
	private final IMazeGenerator generator;
	
	private MazeFactory(IMazeGenerator generator) {
		this.generator = generator;
	}
	
	public synchronized static IMazeGrid newSimpleGrid(String saveTo, int width, int height) {
		if (MazeFactory.factory == null){
			MazeFactory.factory = new MazeFactory(new SimpleMazeGenerator());
		}
		
		return factory.generator.generateMaze(saveTo, width, height);
	}
}
