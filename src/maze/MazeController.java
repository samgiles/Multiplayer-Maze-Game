package maze;

import com.MoveDirection;
import com.graphics.IGraphicsContext;
import com.maze.IMaze;
import com.maze.IMazeCell;

public class MazeController {

	private IMaze maze;
	
	
	public MazeController(IMaze maze) {
		this.maze = maze;
	}

	public IMazeCell getStart() {
		return maze.getStartCell();
	}
	
	public void draw(IGraphicsContext context) {
		this.maze.draw(context);
	}
	
	public boolean queryCollision(int row, int col, MoveDirection direction) {
		IMazeCell cell = maze.getMazeCell(row, col);
		return !cell.isWall(direction);
	}
}
