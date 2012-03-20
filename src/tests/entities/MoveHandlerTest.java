package tests.entities;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.MovementListener;

import tests.entities.mockobjects.MockMoveHandler;
import tests.entities.mockobjects.MockMovementListener;

public class MoveHandlerTest {

	private MockMoveHandler moveHandler;
	
	@Before
	public void setUp() throws Exception {
		moveHandler = new MockMoveHandler();
	}

	@After
	public void tearDown() throws Exception {
		// Reset the move handler.
		moveHandler = null;
	}
	
	/**
	 * This tests the MoveHandler listen function, it also tests the notficcation functions as it makes sense to test it all here.
	 */
	@Test
	public void testListen() {
		// This test set's a bit field to indicate success.

		// Each time an anonymous method is called below they switch off their respective bit using the XOR operatotor
		// If the assertion that flags is == to 0 is true at the end the test should pass.
		MockMovementListener mockListener = new MockMovementListener();
		
		moveHandler.listen(mockListener);
		
		moveHandler.triggerUp();
		assertTrue("Test the up listen handler", (mockListener.getFlags() ^ MockMovementListener.UPBIT) == 0x00000F);
		// flip the bit back and test, why not?
		moveHandler.triggerUp();
		assertTrue("Re test the up listen handler", mockListener.getFlags() == 0x00000F);
		
		
		moveHandler.triggerDown();
		assertTrue("Test the down listen handler", (mockListener.getFlags() ^ MockMovementListener.DOWNBIT) == 0x00000F);
		moveHandler.triggerDown();
		assertTrue("Re Test the down listen handler", mockListener.getFlags() == 0x00000F);
		
		moveHandler.triggerLeft();
		assertTrue("Test the left listen handler", (mockListener.getFlags() ^ MockMovementListener.LEFTBIT) == 0x00000F);
		moveHandler.triggerLeft();
		assertTrue("Re Test the left listen handler", mockListener.getFlags() == 0x00000F);
		
		moveHandler.triggerRight();
		assertTrue("Test the right listen handler", (mockListener.getFlags() ^ MockMovementListener.RIGHTBIT) == 0x00000F);
		moveHandler.triggerRight();
		assertTrue("Re Test the right listen handler", mockListener.getFlags() == 0x00000F);
	}

}
