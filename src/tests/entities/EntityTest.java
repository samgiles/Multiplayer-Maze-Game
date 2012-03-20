/**
 * 
 */
package tests.entities;


import static org.junit.Assert.*;

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
	}
	
	@Test
	public void testGetSetScore() {
		// Set score
		testEntity.setScore(100);
		assertTrue(testEntity.getScore() == 100);
	}

}
