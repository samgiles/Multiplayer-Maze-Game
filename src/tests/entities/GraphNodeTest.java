package tests.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.MoveDirection;
import com.graphics.IGraphicsContext;
import com.maze.IMaze;
import com.maze.IMazeCell;

import ai.GraphNode;

public class GraphNodeTest {

	
	private class MockCell implements IMazeCell {

		int x;
		int y;
		
		public MockCell(int x, int y) {
			this.x = x;
			this.y = y;
		}
		

		public boolean isWall(MoveDirection direction) {
			return (direction != MoveDirection.UP);
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
	
	private class MockMaze implements IMaze {

		IMazeCell[][] cells;
		
		public MockMaze() {
			cells = new IMazeCell[10][10];
			
			for (int i = 0; i < 10; i++) {
				cells[1][i] = new MockCell(1, i);
			}
		}
		
		@Override
		public int getSizeX() {
			return 10;
		}

		@Override
		public int getSizeY() {
			return 10;
		}

		@Override
		public IMazeCell getMazeCell(int x, int y)
				throws IllegalArgumentException {
			return cells[x][y];
		}

		@Override
		public IMazeCell getStartCell() {
			return cells[1][0];
		}

		@Override
		public IMazeCell getEndCell() {
			return cells[1][9];
		}

		@Override
		public MoveDirection getEndDirection() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public MoveDirection getStartDirection() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void draw(IGraphicsContext g) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Test
	public void testCreate() {
		IMaze maze =  new MockMaze();
		GraphNode node = new GraphNode(maze.getStartCell(), maze, null, null);
		node.init(maze.getEndCell());
	}

}
