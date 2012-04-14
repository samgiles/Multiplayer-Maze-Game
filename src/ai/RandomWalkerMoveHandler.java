package ai;

import com.MoveDirection;

import entities.MoveHandler;

public class RandomWalkerMoveHandler extends MoveHandler {
	
	boolean first = true;
	
	public void Update(double delta) {
		double value = (Math.random() * 100);
		
		if (value < 25) {
			this.notify(MoveDirection.UP);
			return;
		}
		
		if (value >= 25 && value < 50) {
			this.notify(MoveDirection.LEFT);
			return;
		}
		
		if (value >= 50 && value < 70) {
			if (first) {
				first = false;
				this.notify(MoveDirection.UP);
				this.notify(MoveDirection.RIGHT);
				return;
			}
			this.notify(MoveDirection.DOWN);
			return;
		}
		
		if (value >= 70) {
			this.notify(MoveDirection.RIGHT);
		}
	}
	
}
