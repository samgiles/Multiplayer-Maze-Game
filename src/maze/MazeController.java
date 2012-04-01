package maze;

import com.graphics.IGraphicsContext;
import com.maze.IMaze;

public class MazeController {

	private IMaze maze;
	
	
	public MazeController(IMaze maze) {
		this.maze = maze;
	}
	
	public void draw(IGraphicsContext context) {
		this.maze.draw(context);
	}
}
