package wlv.mazegenerator;

/**
 * @author Gordon Branson.
 */

public class CellRef {
	private int row;
	private int col;
	private char dir;

	public CellRef() {
		return;
	}

	public CellRef(int row, int col, char dir) {
		this.row = row;
		this.col = col;
		this.dir = dir;
		return;
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

	public char getDir() {
		return dir;
	}

	public void setDir(char dir) {
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "CellRef [row=" + row + ", col=" + col + ", dir=" + dir + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CellRef) {
			CellRef that = (CellRef) obj;
			if ((this.row == that.row) && (this.col == that.col)
					&& (this.dir == that.dir))
				return true;
			return false;
		}
		return false;
	}

}
