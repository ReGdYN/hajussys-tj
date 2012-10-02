
package yl1;

/**
 *
 * @author Taavi Jaanson
 */

public class Ülemus implements Runnable{
	
    private Järjekord järjekord;
	
    Ülemus(Järjekord järjekord) {
	this.järjekord = järjekord;
	new Thread(this).start();
    }

    @Override
    public void run() {
	int i = 1;
	while(true) {
            Töö t = new Töö(i, Töö.uusTöö() );
            järjekord.lisaTöö(t);
            System.out.println("Ülemus lisas töö nr " + t.annaNumber() );
            try {
    		Thread.sleep(1000);
            } catch (InterruptedException e) {}
		i++;
	}
    }

}
