
package yl3;

/**
 *
 * @author Taavi Jaanson
 */

public class Tegevus {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Järjekord järjekord = new Järjekord();
	Järjekord järjekord1 = new Järjekord();
	Järjekord järjekord2 = new Järjekord();
	Tööline tööline1 = new Tööline(järjekord,järjekord1,1);
	Tööline tööline2 = new Tööline(järjekord1,järjekord2,2);
	Tööline tööline3 = new Tööline(järjekord2,3);
	Ülemus ülemus = new Ülemus(järjekord);
    }

}
