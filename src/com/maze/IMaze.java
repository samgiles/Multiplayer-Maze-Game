/**
 * 
 */
package com.maze;

import com.graphics.IGraphicsContext;

/**
 * @author Samuel Giles
 *
 */
public interface IMaze extends IMazeGrid {

	/**
	 * Draws the maze to the specified graphics context.
	 * @param g
	 */
	public void draw(IGraphicsContext g);
}