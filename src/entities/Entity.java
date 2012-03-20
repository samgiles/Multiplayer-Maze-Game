package entities;

public class Entity {
	
	/**
	 * The current score for this entity.
	 */
	private int score;
	
	/**
	 * Creates a new Entity.
	 */
	public Entity() {
	  this.score = 0;
	}
	
	/**
	 * Get the current score for this entity.
	 * @return int The entities score.
	 */
	public int getScore() {
	  return this.score;
	}
	
	/**
	 * Set the current score for this entity.
	 * @param score int The score to give this entity.
	 */
	public void setScore(int score) {
	  this.score = score;
	}
	
}
