/**
 * 
 */
package tests.entities.mockobjects;

import entities.MovementListener;

/**
 * This is a MockMovementListener that can be used to test MovementHandlers, everytime a MovementHandler invokes one of the handling methods, a bit is toggled in the flags.
 * See inside the class for details on which method toggles which bit.  All flags are on to begin with, flags = 0x00000F;
 * @author Samuel Giles
 */
public class MockMovementListener extends MovementListener {
	
	// This test set's a bit field to indicate method invocation, one invocation off, another invocation on and so on..
	private int flags = 0x00000F;
	
	public static int UPBIT    = 1;
	public static int DOWNBIT  = 2;
	public static int LEFTBIT  = 4;
	public static int RIGHTBIT = 8;
	
	public int getFlags() {
		return flags;
	}
	
	/**
	 * Toggles low bit. (1st bit)
	 */
	@Override
	public void onMoveUp(){
		flags = flags ^ UPBIT;
	}
	
	/**
	 * Toggles 2nd bit.
	 */
	@Override
	public void onMoveDown(){
		flags = flags ^ DOWNBIT;
	}
	
	/**
	 * Toggles third bit.
	 */
	@Override
	public void onMoveLeft(){
		flags = flags ^ LEFTBIT;
	}
	
	/**
	 * Toggles fourth bit.
	 */
	@Override
	public void onMoveRight(){
		flags = flags ^ RIGHTBIT;
	}
}
