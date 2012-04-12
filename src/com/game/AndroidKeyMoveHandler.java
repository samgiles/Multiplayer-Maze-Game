package com.game;
import android.view.KeyEvent;

import com.MoveDirection;

import entities.MoveHandler;

public class AndroidKeyMoveHandler extends MoveHandler {
	
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
			case KeyEvent.KEYCODE_DPAD_UP:
				this.notify(MoveDirection.UP);
				break;
			case KeyEvent.KEYCODE_DPAD_DOWN:
				this.notify(MoveDirection.DOWN);
				break;
			case KeyEvent.KEYCODE_DPAD_LEFT: 
				this.notify(MoveDirection.LEFT);
				break;
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				this.notify(MoveDirection.RIGHT);
				break;
		}
	}
}
