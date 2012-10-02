
package yl2;

/**
 *
 * @author Taavi Jaanson
 */

import java.util.Arrays;
import java.util.Random;

public class Liige implements Runnable {
	
    private int nr;
    private Järjekord järjekord;

    Liige(Järjekord järjekord, int nr) {
        this.järjekord = järjekord;
        this.nr = nr;
        new Thread(this).start();
    }
	
    @Override
    public void run() {
	Töö t;
	int[] korras;
	int i = 1;
        while (true) {
            Töö w = new Töö(i, Töö.uusTöö());
            järjekord.lisaTöö(w);
            t = järjekord.võtaTöö();
            korras = teeTöö(t.t);
            System.out.println("Tööline " + this.nr + " - tehtud: " + Arrays.toString(korras));
            try {
		Thread.sleep(paus());
            } catch (InterruptedException e) {
		e.printStackTrace();
            }	
        }		
    }
	
    int[] teeTöö(int[] a) {
	boolean vahetatud = true;
	int j = 0;
	int temp;
	while (vahetatud) {
            vahetatud = false;
            j++;
            for (int i = 0; i < a.length - j; i++) {                                       
                if (a[i] > a[i + 1]) {                          
                    temp = a[i];
	            a[i] = a[i + 1];
	            a[i + 1] = temp;
	            vahetatud = true;
	        }
            }                
	}
	return a;
    }
	
    public int paus() {
    	int b = 2000;
    	int c = 1000;
	Random randomGenerator = new Random();
	int d = randomGenerator.nextInt(b) + c;
	return d;
    }

}

