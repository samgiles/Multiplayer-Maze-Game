package com.graphics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;



public class AndroidGraphicsContext implements IGraphicsContext {

	private final Canvas graphics;
	private int color;
	
	private Paint paint;
	
	public AndroidGraphicsContext(Canvas graphics) {
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(0x00); // black
		this.graphics = graphics;
	}
	
	@Override
	public void drawText(String text, float x, float y) {
		graphics.drawText(text, x, y, paint);
	}

	@Override
	public void drawText(char[] text, int offset, float x, float y) {
		graphics.drawText(text, offset, text.length - offset, x, y, paint);
	}

	@Override
	public void drawLine(float startX, float startY, float stopX, float stopY) {
		graphics.drawLine(startX, startY, stopX, stopY, paint);
	}
	
	@Override
	public void drawLine (int startX, int startY, int stopX, int stopY) {
		graphics.drawLine(startX, startY, stopX, stopY, paint);
	}

	@Override
	public void setColor(int red, int green, int blue) {
		this.color = Color.rgb(red, green, blue);
		paint.setColor(this.color);	
	}

	@Override
	public void drawChars(char[] data, int i, int length, int x, int y) {
		graphics.drawText(data.toString().substring(i, length), x, y, paint);
	}
	

	@Override
	public int getColor() {
		return this.color;
	}

	@Override
	public void fillOval(int x, int y, int width, int height) {
		Paint.Style oldStyle = paint.getStyle();
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		graphics.drawOval(new RectF(y, x, y + height, x + width), paint);
		paint.setStyle(oldStyle);
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		Paint.Style oldStyle = paint.getStyle();
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		graphics.drawRect(new RectF(y, x, y + height, x + width), paint);
		paint.setStyle(oldStyle);
	}

	@Override
	public void setColor(int color) {
		this.color = color;
		this.paint.setColor(color);
	}
}
