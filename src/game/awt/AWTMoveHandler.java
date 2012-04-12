package game.awt;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.MoveDirection;

import entities.MoveHandler;

public class AWTMoveHandler extends MoveHandler implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
			case KeyEvent.VK_UP:
				this.notify(MoveDirection.UP);
				break;
			case KeyEvent.VK_DOWN:
				this.notify(MoveDirection.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				this.notify(MoveDirection.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				this.notify(MoveDirection.RIGHT);
				break;
			default:
				// EMPTY DEAULT
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		return; // Do nothing
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		return; // Do nothing
	}
}
