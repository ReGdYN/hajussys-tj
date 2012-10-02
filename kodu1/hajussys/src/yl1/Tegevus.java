
package yl1;

/**
 *
 * @author Taavi Jaanson
 */

public class Tegevus {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Järjekord järjekord = new Järjekord();
	Tööline tööline1 = new Tööline(järjekord, 1);
	Tööline tööline2 = new Tööline(järjekord, 2);
	Tööline tööline3 = new Tööline(järjekord, 3);
	Ülemus ülemus = new Ülemus(järjekord);
    }

}
