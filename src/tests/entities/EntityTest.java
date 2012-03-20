/**
 * 
 */
package tests.entities;


import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Entity;

/**
 * Test case for the Entity
 * @author Samuel Giles
 */
public class EntityTest {

	
	private Entity testEntity;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testEntity = new Entity();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		testEntity = null;
	}
	
	@Test
	public void testGetSetPositionY() {
		Random rand = new Random();
		
		// Run this with 4 different random numbers:
		int i = 5;
		
		while (--i != 0) {
			double randomTestNumber = rand.nextDouble();
			testEntity.setPositionY(randomTestNumber);
			assertTrue("Test the position was set correctly to the random test number: " + String.valueOf(randomTestNumber), testEntity.getPositionY() == randomTestNumber);
		}
	}
	
	
	@Test
	public void testAddToPositionY() {
		// Make sure initial X value is 0.
		testEntity.setPositionY(0);
		// Add 100, then test if new score is 100.
		testEntity.addToPositionY(100);
		assertTrue("Check Test entity's value increased from 0 to 100", testEntity.getPositionY() == 100);
		testEntity.addToPositionY(-200);
		assertTrue("Check Test entity's value decreased from 100 to -100", testEntity.getPositionY() == -100);
	}
	
	@Test
	public void testGetSetPositionX() {
		Random rand = new Random();
		
		// Run this with 4 different random numbers:
		int i = 5;
		
		while (--i != 0) {
			double randomTestNumber = rand.nextDouble();
			testEntity.setPositionX(randomTestNumber);
			assertTrue("Test the position was set correctly to the random test number: " + String.valueOf(randomTestNumber), testEntity.getPositionX() == randomTestNumber);
		}
	}
	
	
	@Test
	public void testAddToPositionX() {
		// Make sure initial X value is 0.
		testEntity.setPositionX(0);
		// Add 100, then test if new score is 100.
		testEntity.addToPositionX(100);
		assertTrue("Check Test entity's value increased from 0 to 100", testEntity.getPositionX() == 100);
		testEntity.addToPositionX(-200);
		assertTrue("Check Test entity's value decreased from 100 to -100", testEntity.getPositionX() == -100);
	}
	
	@Test
	public void testGetSetScore() {
		// Set score
		testEntity.setScore(100);
		assertTrue(testEntity.getScore() == 100);
	}

}
