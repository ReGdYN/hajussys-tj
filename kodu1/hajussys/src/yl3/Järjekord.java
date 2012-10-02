
package yl3;

/**
 *
 * @author Taavi Jaanson
 */

import java.util.LinkedList;


public class Järjekord {
	
    static LinkedList <Töö> järjekord = new LinkedList <Töö>();
    Järjekord() {}

    synchronized void lisaTöö(Töö t) {
        järjekord.addLast(t);
        notify();
    }

    synchronized Töö võtaTöö() {
        while (järjekord.isEmpty()) {
            try {
                wait();
            } catch (Exception e) {}
            }
        return (Töö) järjekord.removeFirst();
    }
    
    static int mituTööd() {
    	return järjekord.size();
    }
    
}

