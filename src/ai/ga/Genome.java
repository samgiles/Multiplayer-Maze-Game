package ai.ga;

import java.util.*;

public class Genome {
	public BitSet bits;
	public double fitness = 0;

	public Genome(BitSet bits) {
		this.bits = bits;
	}
	
	public Genome(int num) {
		Random rand  =new Random();
		
		bits = new BitSet();
		
		for (int i = 0; i < num; ++i) {
			if (rand.nextInt(2) == 1) {
				bits.set(i);
			} else {
				bits.clear(i);
			}
		}
	}
}
