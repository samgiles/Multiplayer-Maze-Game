package tests.entities;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.*;

import tests.entities.mockobjects.MockMoveHandler;

import entities.*;

/**
 * Tests for the EntityController
 * @author Samuel Giles
 */
public class EntityControllerTest {

	private MockMoveHandler moveHandler = new MockMoveHandler();
	private Entity testEntity;
	private EntityController entityController;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testEntity = new Entity();
		entityController = new EntityController(testEntity, moveHandler);
		testEntity.setPositionX(0);
		testEntity.setPositionY(0);
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
		// Test that the entity is the same as the entity passed to the constructor.
		assertTrue(testEntity == entityController.getEntity());
	}
	
	/**
	 * Tests the controller movement handling.
	 */
	@Test
	public void testMoveUpHandled() {
		// Set the position to (0,0)
		testEntity.setPositionX(0);
		testEntity.setPositionY(0);
		
		// trigger the UP movement a random n  times, this should move the entity to (0,-(EntityController.MOVECONSTANT * n)) position
		int n = getRandomNumber();
		int i = n;
		while(i-- > 0) {
			moveHandler.triggerUp();
		}
		
		// the controller should have heard those movements, and translated it to the entity.
		assertTrue(testEntity.getPositionY() == -(n * EntityController.MOVE_CONSTANT));
	}
	
	/**
	 * Tests the controller movement handling.
	 */
	@Test
	public void testMoveDownHandled() {
		
		// trigger the DOWN movement a random n  times, this should move the entity to (0,(EntityController.MOVECONSTANT * n)) position
		int n = getRandomNumber();
		int i = n;
		while(i-- > 0) {
			moveHandler.triggerDown();
		}
		
		// the controller should have heard those movements, and translated it to the entity.
		assertTrue(testEntity.getPositionY() == (n * EntityController.MOVE_CONSTANT));
	}
	
	/**
	 * Tests the controller movement handling.
	 */
	@Test
	public void testMoveLeftHandled() {
		// trigger the left movement a random n  times, this should move the entity to (-(EntityController.MOVECONSTANT * n), 0) position
		int n = getRandomNumber();
		int i = n;
		while(i-- > 0) {
			moveHandler.triggerLeft();
		}
		
		// the controller should have heard those movements, and translated it to the entity.
		assertTrue(testEntity.getPositionX() == -(n * EntityController.MOVE_CONSTANT));
	}
	
	/**
	 * Tests the controller movement handling.
	 */
	@Test
	public void testMoveRightHandled() {
		
		// trigger the right movement a random n  times, this should move the entity to ((EntityController.MOVECONSTANT * n), 0) position
		int n = getRandomNumber();
		int i = n;
		while(i-- > 0) {
			moveHandler.triggerRight();
		}
		
		// the controller should have heard those movements, and translated it to the entity.
		assertTrue(testEntity.getPositionX() == (n * EntityController.MOVE_CONSTANT));
	}
	
	private int getRandomNumber() {
		Random rand = new Random();
		return (rand.nextInt(25) + 1) << 1; // Max of 50 min of 2
	}

}
