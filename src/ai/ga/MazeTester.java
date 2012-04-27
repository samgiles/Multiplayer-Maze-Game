package ai.ga;

import java.util.BitSet;
import java.util.List;
import java.util.Random;

import com.MoveDirection;
import com.Tuple;

import entities.Entity;
import entities.EntityController;
import entities.MoveHandler;
import game.Game;
import maze.MazeController;

/**
 * Runs a set of instructions on a maze to determine where the end point would be taking into account collisions.
 * @author sam
 *
 */
public class MazeTester {

	class InstructionExecutor extends MoveHandler {
		
		List<MoveDirection> directions;
		
		public InstructionExecutor() {
			this.directions = GAController.bitsToEncoding(MazeTester.this.set);
		}
		
		public void go() {
			int i = 0;
			for(;i< directions.size(); i++) {
				try {
					this.notify(directions.get(i));
				} catch (NullPointerException e) {
					// This means we found a route!
					MazeTester.this.e.setPositionY(-1);
					return;
				}
				
				if (MazeTester.this.doPermutations(i, directions.get(i))) {
					this.directions = GAController.bitsToEncoding(MazeTester.this.set);
					i -= 1;
				}
				
			}
		}
	}
	
	private double lastFitness = 0;
	private double lastX = 0;
	private double lastY = 0;
	
	private boolean doPermutations(int i, MoveDirection direction) {
		// Calculate fitness.
		int diffX = (int) Math.abs(e.getPositionX()- maze.getMaze().getEndCell().getX());
		int diffY = (int) Math.abs(e.getPositionY() - maze.getMaze().getEndCell().getY());
		
		double fitness = 1 / (double)(diffX + diffY + 1);
		
		if (e.getPositionX() == lastX || e.getPositionY() == lastY) {
			efficiencyFactor += 0.1;
		}
		
		lastX = e.getPositionX();
		lastY = e.getPositionY();
		
		if (fitness > lastFitness) {
			lastFitness = fitness;
			return false;
		} else {
			lastFitness = fitness;
			if (r.nextFloat() < 0.009) {
				i = i * 2;
				// hmm we're going backwards/not changing in terms of how awesome we are go back a step and permute that direction...
				BitSet previous = set.get(i, i + 2);
				int decimal = GAController.bitsToDecimal(previous, 2);
				int encoding = GAController.encodings.get(direction);
				
				set.clear(i, i+2);
				
				int n = decimal;
				while (n == decimal) {
					n = r.nextInt(4);
				}
				
				set.set(i, (n & 1) != 0);
				set.set(i+1, (n & 2) != 0);
				
				return true;
			}
		}
		
		return false;
	}
	
	Random r = new Random();
	MazeController maze;
	Entity e = new Entity();
	Game fakeGame;
	InstructionExecutor executor;
	final BitSet set;
	
	int efficiencyFactor = 0;
	
	public MazeTester(MazeController maze, BitSet directions) {
		this.maze = maze;
		e.setPositionX(maze.getStart().getX());
		e.setPositionY(maze.getStart().getY());
		lastX = e.getPositionX();
		lastY = e.getPositionY();
		set = directions;
		executor = new InstructionExecutor();
		fakeGame = new Game(maze, executor, e);
	}
	
	Tuple<Double, Double> run() {
		executor.go();
		return new Tuple<Double, Double>(e.getPositionX(), e.getPositionY() - efficiencyFactor);
	}
	
}
