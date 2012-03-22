/**
 * 
 */
package com.maze;

/**
 * @author sam
 *
 */
public final class MazeFactory {

	private static Object lock = new Object();
	
	private static MazeFactory factory = null;
	
	private final IMazeGenerator generator;
	
	private MazeFactory(IMazeGenerator generator) {
		this.generator = generator;
	}
	
	public static IMazeGrid newSimpleGrid(String saveTo, int width, int height) {
		
		synchronized(lock) {
			if (MazeFactory.factory == null){
				MazeFactory.factory = new MazeFactory(new SimpleMazeGenerator());
			}
		}
		
		return factory.generator.generateMaze(saveTo, width, height);
	}
}
