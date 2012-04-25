package wlv.mazegenerator;

/**
 * @author Gordon Branson.
 */

public class CellReference {
	private int row;
	private int col;
	private char dir;

	public CellReference() {
		return;
	}

	public CellReference(int row, int col, char dir) {
		this.row = row;
		this.col = col;
		this.dir = dir;
		return;
	}

	public int getX() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getY() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public char getDirection() {
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
		if (obj instanceof CellReference) {
			CellReference that = (CellReference) obj;
			if ((this.row == that.row) && (this.col == that.col)
					&& (this.dir == that.dir))
				return true;
			return false;
		}
		return false;
	}

}
