package wlv.mazegenerator;

/**
 *  @author Gordon Branson.
 */

import java.awt.Color;
import java.awt.Graphics;

import com.graphics.IGraphicsContext;

public class Cell {
	private boolean wallN;
	private boolean wallS;
	private boolean wallE;
	private boolean wallW;
	private int number;

	/**
	 * 
	 */
	public Cell() {
		this.wallN = true;
		this.wallS = true;
		this.wallE = true;
		this.wallW = true;
		this.number = 0;
	}

	/**
	 * @param wallN
	 * @param wallS
	 * @param wallE
	 * @param wallW
	 * @param number
	 */
	public Cell(boolean wallN, boolean wallS, boolean wallE, boolean wallW,
			int number) {
		this.wallN = wallN;
		this.wallS = wallS;
		this.wallE = wallE;
		this.wallW = wallW;
		this.number = number;
	}

	public boolean isWallN() {
		return wallN;
	}

	public void setWallN(boolean wallN) {
		this.wallN = wallN;
	}

	public boolean isWallS() {
		return wallS;
	}

	public void setWallS(boolean wallS) {
		this.wallS = wallS;
	}

	public boolean isWallE() {
		return wallE;
	}

	public void setWallE(boolean wallE) {
		this.wallE = wallE;
	}

	public boolean isWallW() {
		return wallW;
	}

	public void setWallW(boolean wallW) {
		this.wallW = wallW;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean getIfWall(char dir) {
		switch (dir) {
		case 'n':
		case 'N':
			return wallN;
		case 's':
		case 'S':
			return wallS;
		case 'e':
		case 'E':
			return wallE;
		case 'w':
		case 'W':
			return wallW;
		}
		return false;
	}

	public void setWall(char dir) {
		switch (dir) {
		case 'n':
		case 'N':
			wallN = true;
			break;
		case 's':
		case 'S':
			wallS = true;
			break;
		case 'e':
		case 'E':
			wallE = true;
			break;
		case 'w':
		case 'W':
			wallW = true;
		}
	}

	public void clearWall(char dir) {
		switch (dir) {
		case 'n':
		case 'N':
			wallN = false;
			break;
		case 's':
		case 'S':
			wallS = false;
			break;
		case 'e':
		case 'E':
			wallE = false;
			break;
		case 'w':
		case 'W':
			wallW = false;
		}
	}

	private void doDraw(IGraphicsContext g, int size, int x, int y) {
		if (wallS) {
			g.drawLine(x, y + size, x + size, y + size);
			g.drawLine(x, y + size - 1, x + size, y + size - 1);
		}
		if (wallN) {
			g.drawLine(x, y, x + size, y);
			g.drawLine(x, y + 1, x + size, y + 1);
		}
		if (wallW) {
			g.drawLine(x, y, x, y + size);
			g.drawLine(x + 1, y, x + 1, y + size);
		}
		if (wallE) {
			g.drawLine(x + size, y, x + size, y + size);
			g.drawLine(x + size - 1, y, x + size - 1, y + size);
		}
	}
	
	public void draw2D(IGraphicsContext g, int size, int x, int y) {
		g.setColor(0, 200, 0);
		doDraw(g, size, x, y);
	}

	public void draw(IGraphicsContext g, int size, int x, int y) {
		doDraw(g, size, x, y);
		String numStr = "" + number;
		char[] data = numStr.toCharArray();
		g.drawChars(data, 0, data.length, x + 5, y + (size / 2));
	}
}
