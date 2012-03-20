package entities;

public class Entity {
	
	/**
	 * The current score for this entity.
	 */
	private int score;
	
	/**
	 * The current X position of the entity.
	 */
	private double positionX;
	
	/**
	 * The current Y position of the entity.
	 */
	private double positionY;
	
	/**
	 * Creates a new Entity.
	 */
	public Entity() {
	  this.score = 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getPositionX() {
		return this.positionX;
	}
	
	/**
	 * Adds a value on to the current X position of the entity.
	 * @param value double A signed value that will be added to the X position, so a negative number will decrease X and a positive value will increase X
	 */
	public void addToPositionX(double value) {
		this.positionX += value;
	}
	
	/**
	 * Sets the X position of the entity.
	 * @param value
	 */
	public void setPositionX(double value) {
		this.positionX = value;
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
