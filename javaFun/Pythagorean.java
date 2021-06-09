//Done with Khalil Khalil
import java.lang.Math;
public class Pythagorean {
    public double calculateHypotenuse(double legA, double legB) {
        // the hypotenuse is the side across from the right angle. 
        // calculate the value of c given legA and legB
		double x = legA*legA;
        double b = legB*legB;
        double c = x+b;
		double y =  Math.sqrt(c);
        return (y);
    }
}

