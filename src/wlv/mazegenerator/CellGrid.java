package wlv.mazegenerator;

/**
 *  @author Gordon Branson.
 */

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

import com.graphics.IGraphicsContext;

public class CellGrid {

	private final int SIZE = 30;
	private int row;
	private int col;
	private Cell[][] grid;
	private CellReference currentCell;
	private CellReference start;
	private CellReference exit;
	private boolean loopEnabled;

	public CellGrid() {
		row = 10;
		col = 10;
		loopEnabled = false;
		createNewGrid();
		currentCell = new CellReference();
		start = new CellReference();
		exit = new CellReference();
	}

	public CellGrid(int row, int col, boolean loopEnabled) {
		this.row = row;
		this.col = col;
		this.loopEnabled = loopEnabled;
		currentCell = new CellReference(0, 0, 'N');
		createNewGrid();
		start = new CellReference(0, 0, 'N');
		exit = new CellReference(0, col - 1, 'S');
	}

	public final void createNewGrid() {
		grid = new Cell[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				grid[r][c] = new Cell();
			}
		}
		for (int i = 0; i < col; i++) {
			grid[0][i].setWall('S');
			grid[row - 1][i].setWall('N');
		}
		for (int j = 0; j < row; j++) {
			grid[j][0].setWall('W');
			grid[j][col - 1].setWall('E');
		}
	}

	public void draw2D(IGraphicsContext g) {
		Color old = new Color(g.getColor());
		g.setColor(0, 0, 0);
		g.fillRect(0, 0, col * SIZE + 10, row * SIZE + 10);
		g.setColor(old.getRed(), old.getGreen(), old.getBlue());
		int x = 0;
		int y = SIZE * (row - 1);
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				grid[r][c].draw2D(g, SIZE, x + (SIZE * c), y - (SIZE * r));
			}
		}
	}

	public void draw(IGraphicsContext g) {
		int x = SIZE;
		int y = SIZE * row;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				grid[r][c].draw(g, SIZE, x + (SIZE * c), y - (SIZE * r));
			}
		}
	}

	public Dimension getSize() {
		return new Dimension(SIZE * row, SIZE * col);
	}

	public int getCellNumber(int r, int c) {
		return grid[r][c].getNumber();
	}

	public void setCellNumber(int r, int c, int n) {
		grid[r][c].setNumber(n);
	}

	public boolean getCellWall(int r, int c, char w) {
		return grid[r][c].getIfWall(w);
	}

	public boolean getCellWall(CellReference cref) {
		return grid[cref.getX()][cref.getY()].getIfWall(cref.getDirection());
	}

	public void setCellWall(int r, int c, char w) {
		grid[r][c].setWall(w);
	}

	public void clearCellWall(int r, int c, char w) {
		grid[r][c].clearWall(w);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Cell[][] getGrid() {
		return grid;
	}

	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

	public CellReference getStart() {
		return start;
	}

	public void setStart(CellReference start) {
		this.start = start;
	}

	public CellReference getExit() {
		return exit;
	}

	public void setExit(CellReference exit) {
		this.exit = exit;
	}

	public CellReference getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(CellReference currentCell) {
		this.currentCell = currentCell;
	}

	public boolean isLoopEnabled() {
		return loopEnabled;
	}

	public void setLoopEnabled(boolean loopEnabled) {
		this.loopEnabled = loopEnabled;
	}

}
