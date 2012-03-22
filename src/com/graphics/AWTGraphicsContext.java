package com.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class AWTGraphicsContext implements IGraphicsContext {

	private final Graphics graphics;
	
	
	public AWTGraphicsContext(Graphics graphics) {
		this.graphics = graphics;
	}
	
	@Override
	public void drawText(String text, float x, float y) {
		graphics.drawString(text, (int)x, (int)y);
	}

	@Override
	public void drawText(char[] text, int offset, float x, float y) {
		graphics.drawChars(text, offset, text.length, (int)x, (int)y);
	}

	@Override
	public void drawLine(float startX, float startY, float stopX, float stopY) {
		graphics.drawLine((int)startX, (int)startY, (int)stopX, (int)stopY);
	}
	
	@Override
	public void drawLine (int startX, int startY, int stopX, int stopY) {
		graphics.drawLine(startX, startY, stopX, stopY);
	}

	@Override
	public void setColor(int red, int green, int blue) {
		graphics.setColor(new java.awt.Color(red, green, blue));		
	}

	@Override
	public void drawChars(char[] data, int i, int length, int x, int y) {
		graphics.drawChars(data, data.length, length, x, y);
	}
	

	@Override
	public int getColor() {
		return graphics.getColor().getRGB();
	}

	@Override
	public void fillOval(int x, int y, int width, int height) {
		graphics.fillOval(x, y, width, height);
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		graphics.fillRect(x, y, width, height);
	}
}
