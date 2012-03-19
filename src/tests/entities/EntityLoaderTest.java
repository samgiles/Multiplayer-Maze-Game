package tests.entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tests.entities.mockobjects.MockEntityDataSource;

import entities.Entity;
import entities.EntityLoader;

public class EntityLoaderTest {

	private EntityLoader loader;
	
	@Before
	public void setUp() throws Exception {
		loader = new EntityLoader(new MockEntityDataSource());
	}

	@Test
	public void testStoreAndLoad() {
		Entity entity = new Entity();
		loader.store(entity);
		
		assertTrue(loader.load() == entity);
	}

}
