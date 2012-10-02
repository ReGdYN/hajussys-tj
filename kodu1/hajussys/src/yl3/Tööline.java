/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yl3;

/**
 *
 * @author Taavi Jaanson
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Tööline implements Runnable {
	
    private int nr;
    private Järjekord järjekord;
    private Järjekord järjekordNext;

    Tööline(Järjekord järjekord, int nr) {
        this.järjekord = järjekord;
        this.nr = nr;
        new Thread(this).start();
    }
	
    Tööline(Järjekord järjekord, Järjekord järjekordNext, int nr) {
        this.järjekord = järjekord;
        this.nr = nr;
        this.järjekordNext = järjekordNext;
        new Thread(this).start();
    }
	
    public void run() {
        Töö t;
        int[] korras;
        while (true) {
            if (this.nr == 1) {
                t = järjekord.võtaTöö();
                korras = teeTöö(t.t);
                t.vahetaJarjend(korras);
                järjekordNext.lisaTöö(t);
                System.out.println("Tööline " + this.nr + " tegi oma osa ära.    |||   " + Arrays.toString(korras));		        	
            } else if (this.nr == 2) {
                t = järjekord.võtaTöö();
                korras = järjestaÜmber(t.t);
                t.vahetaJarjend(korras);
                järjekordNext.lisaTöö(t);
                System.out.println("Tööline " + this.nr + " tegi oma osa ära.    |||   " + Arrays.toString(korras));
            } else {
                t = järjekord.võtaTöö();
                korras = keskmine(t.t);
                System.out.println("Tööline " + this.nr + " tegi oma osa ära.    |||   " + korras[0]);
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
	
    public static int[] järjestaÜmber(int[] t) {
        int temp;
        for (int i = 0; i <= Math.floor(t.length)/2;i++) {
            temp = t[i];
            t[i] = t[t.length-1-i];
            t[t.length-1-i] = temp;
        }
        return t;
    }
	
    public static int[] keskmine(int[] t) {
        int[] a = {0};
        for (int i = 0; i < 25;i++) {
            a[0] += t[i];
        }
        a[0] = Math.round(a[0]/25);
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

