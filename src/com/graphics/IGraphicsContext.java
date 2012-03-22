package com.graphics;

/**
 * Provides a subset of graphics functions that can be used to create portable drawing functions.
 * @author Samuel Giles
 *
 */
public interface IGraphicsContext {

	/**
	 * 
	 * @param text
	 * @param start
	 * @param end
	 * @param x
	 * @param y
	 */
	void drawText(String text, float x, float y);
	
	/**
	 * 
	 * @param text
	 * @param offset
	 * @param x
	 * @param y
	 */
	void drawText(char[] text, int offset, float x, float y);
	
	void drawChars(char[] data, int i, int length, int x, int y);
	
	/**
	 * 
	 * @param startX
	 * @param startY
	 * @param stopX
	 * @param stopY
	 */
	void drawLine (float startX, float startY, float stopX, float stopY);
	
	/**
	 * 
	 * @param startX
	 * @param startY
	 * @param stopX
	 * @param stopY
	 */
	void drawLine (int startX, int startY, int stopX, int stopY);

	void setColor(int red, int green, int blue);

	int getColor();
	
	void fillOval(int x, int y, int width, int height);
	
	void fillRect(int x, int y, int width, int height);
	
}
