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
	private CellRef currentCell;
	private CellRef start;
	private CellRef exit;
	private boolean loopEnabled;

	public CellGrid() {
		row = 1;
		col = 1;
		loopEnabled = false;
		createNewGrid();
		currentCell = new CellRef();
		start = new CellRef();
		exit = new CellRef();
	}

	public CellGrid(int row, int col, boolean loopEnabled) {
		this.row = row;
		this.col = col;
		this.loopEnabled = loopEnabled;
		currentCell = new CellRef(0, 0, 'N');
		createNewGrid();
		start = new CellRef(0, 0, 'N');
		exit = new CellRef(0, col - 1, 'S');
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

	public boolean getCellWall(CellRef cref) {
		return grid[cref.getRow()][cref.getCol()].getIfWall(cref.getDir());
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

	public CellRef getStart() {
		return start;
	}

	public void setStart(CellRef start) {
		this.start = start;
	}

	public CellRef getExit() {
		return exit;
	}

	public void setExit(CellRef exit) {
		this.exit = exit;
	}

	public CellRef getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(CellRef currentCell) {
		this.currentCell = currentCell;
	}

	public boolean isLoopEnabled() {
		return loopEnabled;
	}

	public void setLoopEnabled(boolean loopEnabled) {
		this.loopEnabled = loopEnabled;
	}

}
