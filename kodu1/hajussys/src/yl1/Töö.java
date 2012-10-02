
package yl1;

/**
 *
 * @author Taavi Jaanson
 */

import java.util.Random;

public class Töö {
	
    int[] t;
    private static int jrn = 0;
	
    Töö(int jrn, int[] t) {
        Töö.jrn = jrn;
        this.t = t;
    }
	
    int annaNumber() {
        return jrn;
    }
        
    static int[] uusTöö() {
        jrn++;
	int[] jarjend = new int[25];
	for (int i = 0 ; i < 25 ; i++) {
            int b = 25;
            Random randomGenerator = new Random();
            int d = randomGenerator.nextInt(b);
            jarjend[i] = d;
	}
        return jarjend;
    }
    
}
