package tests.entities;

import static org.junit.Assert.*;

import org.junit.*;

import entities.*;

/**
 * Tests for the EntityController
 * @author Samuel Giles
 */
public class EntityControllerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test's the controller.
	 * Test method for {@link entities.EntityController#EntityController(entities.Entity)}.
	 */
	@Test
	public void testEntityController() {
		Entity testEntity = new Entity();
		EntityController entityController = new EntityController(testEntity);
		// Test that the entity is the same as the entity passed to the constructor.
		assertTrue(testEntity == entityController.getEntity());
	}

}
