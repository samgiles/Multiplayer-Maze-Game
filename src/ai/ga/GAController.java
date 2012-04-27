package ai.ga;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.MoveDirection;
import com.Tuple;

import maze.MazeController;

import entities.EntityController;

public class GAController {
	List<Genome> genomes;
	
	int populationSize;
	double crossoverRate;
	double mutationRate;
	int chromosomeLength;
	int geneLength;
	
	int fittestGenome = 0;
	
	int weakestGenome = 1;
	
	double bestFitness;
	
	double bestFitnessInHistory;
	List<Genome> bestGenomesInHistory = new ArrayList<Genome>();
	Genome theBestGenomeInHistory;
	
	double totalFitness;
	
	int generation;
	
	EntityController entity;
	
	MazeController maze;
	
	boolean busy;
	
	boolean foundSolution;
	
	public static final Map<MoveDirection, Integer> encodings;
	
	static {
		Map<MoveDirection, Integer> encoding = new HashMap<MoveDirection, Integer>();
		encoding.put(MoveDirection.UP, 0);
		encoding.put(MoveDirection.DOWN, 1);
		encoding.put(MoveDirection.LEFT, 2);
		encoding.put(MoveDirection.RIGHT, 3);
		
		encodings = Collections.unmodifiableMap(encoding);
	}
	
	public GAController(MazeController maze, double mutationRate, double crossoverRate, int populationSize, int numBits, int geneLength) {
		this.crossoverRate = crossoverRate;
		this.populationSize = populationSize;
		this.chromosomeLength = numBits;
		this.totalFitness = 0;
		this.generation = 0;
		this.geneLength = geneLength;
		this.mutationRate = mutationRate;
		busy = false;
		this.maze = maze;
		this.genomes = new ArrayList<Genome>();
		createStartUpPopulation();
	}
	
	public int getGeneration() {
		return generation;
	}
	
	public int getFittest() {
		return fittestGenome;
	}
	
	public List<MoveDirection> getFittestGenome() {
		return bitsToEncoding(this.theBestGenomeInHistory.bits);
	}
	
	boolean isStarted() {
		return busy;
	}
	
	void stop() {
		busy = false;
	}
	
	void mutate(BitSet bits) {
		Random rand = new Random();
		for (int currentBit = 0; currentBit < bits.size(); currentBit++) {
			if (rand.nextFloat() < this.mutationRate) {
				bits.flip(currentBit);
			}
		}
	}
	
	public static int bitsToDecimal(BitSet bits, int nbits) {
		    int bitInteger = 0;
		    for(int i = 0 ; i < nbits; i++)
		        if(bits.get(i))
		            bitInteger |= (1 << i);
		    return bitInteger;
	}
	
	public static List<MoveDirection> bitsToEncoding(BitSet bits) {
		List<MoveDirection> dirs = new ArrayList<MoveDirection>();
		for (int i = 0; i < bits.size(); i+=2) {
			int decimal = bitsToDecimal (bits.get(i, i+2), 2);
			
			switch(decimal) {
				case 0:
					dirs.add(MoveDirection.UP);
					break;
				case 1:
					dirs.add(MoveDirection.DOWN);
					break;
				case 2:
					dirs.add(MoveDirection.LEFT);
					break;
				case 3:
					dirs.add(MoveDirection.RIGHT);
					break;
			}
			
		} // ignore anymismatches..
		
		return dirs;
	}
	
	Tuple<BitSet, BitSet> crossover(BitSet parentA, BitSet parentB) {
		
		Random rand = new Random();
		
		if ((rand.nextFloat() > this.crossoverRate) || (parentA == parentB)) {
			return new Tuple<BitSet, BitSet>(parentA, parentA);
		}
		
		BitSet childA = new BitSet();
		BitSet childB = new BitSet();
		
		int splitPoint = rand.nextInt(this.chromosomeLength);
		
		for (int i = 0; i < splitPoint; i++) {
			childA.set(i, parentA.get(i));
			childB.set(i, parentB.get(i));
		}
		
		for (int i = splitPoint; i < parentA.size(); i++) {
			childA.set(i, parentB.get(i));
			childB.set(i, parentA.get(i));
		}
		
		return new Tuple<BitSet, BitSet>(childA, childB);
	}
	
	int getFirstOfSequence(BitSet sequence, BitSet bits) {
		for (int i = 0; i < bits.size(); ++i) {
			if (bits.get(i, i + sequence.size()).equals(sequence)) {
				return i;
			}
		}
		
		return -1;
	}
		
	Genome rouletteWheelSelection() {
		Random rand = new Random();
		
		double slice = 	rand.nextFloat() * totalFitness;
		double total = 0;
		int selectedGenome = 0;
		
		for (int i = 0; i < genomes.size(); ++i) {
			total += genomes.get(i).fitness;
			
			if (total > slice) {
				selectedGenome = i;
				break;
			}
		}
		
		return genomes.get(selectedGenome);
	}
	
	void createStartUpPopulation() {
		for (int i = 0; i < this.populationSize; i++) {
			this.genomes.add(new Genome(chromosomeLength));
		}
	}
	
	void epoch() {
		System.out.println("Running Generation: " + generation);
		updateFitnessScores();
		
		this.genomes.addAll(this.bestGenomesInHistory);
		this.genomes.remove(this.weakestGenome);
		
		if (genomes.get(getFittest()).fitness >= 1) {
			busy = false;
			foundSolution = true;
			return;
		}
		
		int nNewGenomes = 0;
		
		List<Genome> newGenomes = new ArrayList<Genome>();
		
		while (nNewGenomes < this.populationSize + 5) {
			Genome parentA = rouletteWheelSelection();
			Genome parentB = rouletteWheelSelection();
			
			Tuple<BitSet, BitSet> children = crossover(parentA.bits, parentB.bits);
			
			mutate(children._A);
			mutate(children._B);
			
			newGenomes.add(new Genome(children._A));
			newGenomes.add(new Genome(children._B));
			
			nNewGenomes += 2;
		}
		
		genomes = newGenomes;
		this.generation++;
	}

	private void updateFitnessScores() {
		this.totalFitness = 0;
		int fittest = 0;
		
		for (int i = 0; i < genomes.size(); ++i) {
			MazeTester tester = new MazeTester(maze, genomes.get(i).bits);
			Tuple<Double, Double> newPosition = tester.run();
			
			int diffX = (int) Math.abs(newPosition._A - maze.getMaze().getEndCell().getX());
			int diffY = (int) Math.abs(newPosition._B - maze.getMaze().getEndCell().getY());
			genomes.get(i).fitness = 1 / (double)(diffX + diffY + 1);
			
			this.totalFitness += genomes.get(i).fitness;
			
			if (genomes.get(fittest).fitness < genomes.get(i).fitness) {
				fittest = i;
				
				if (theBestGenomeInHistory == null || genomes.get(i).fitness > theBestGenomeInHistory.fitness) {
					theBestGenomeInHistory = genomes.get(i);
					bestGenomesInHistory.add(genomes.get(i));
				} else if (genomes.get(i).fitness > (theBestGenomeInHistory.fitness - 0.2)) {
					bestGenomesInHistory.add(genomes.get(i));
				}

				System.out.println("Fittest of all time: " + theBestGenomeInHistory.fitness);
				System.out.println("Fittest So Far: " + genomes.get(i).fitness);
			} else if(genomes.get(i).fitness < genomes.get(this.weakestGenome).fitness) {
				weakestGenome = i;
			}
		}
		
		this.fittestGenome = fittest;
		
		cleanTheElite();
	}
	
	private void cleanTheElite() {
		int maxElite = 5;
		// No clean required.
		if (bestGenomesInHistory.size() < maxElite) {
			return;
		}
		
		Collections.sort(bestGenomesInHistory, new Comparator<Genome>() {

			@Override
			public int compare(Genome arg0, Genome arg1) {
				return (int)(Math.rint(arg0.fitness) - Math.rint(arg1.fitness));
			}});
		
		while (bestGenomesInHistory.size() > maxElite) {
			bestGenomesInHistory.remove(bestGenomesInHistory.size() - 1);
		}
	}
	
	public void run(int maxGenerations) {
		busy = true;
		while(!this.foundSolution && generation < maxGenerations && busy) {
			epoch();
		}
	}
	
}
