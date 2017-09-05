import java.lang.Math;

public class PythagoreanTheorem {
    public double calculateHypotenuse(int legA, int legB) {
        double legone = legA * legA;
        double legtwo = legB * legB;
        double legs = legone + legtwo;
        double hypotenuse = Math.sqrt(legs);
        System.out.println(legs);
        System.out.println(hypotenuse);
        return (hypotenuse);
    }

}
