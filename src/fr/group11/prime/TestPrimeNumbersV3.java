package fr.group11.prime;
import java.math.BigInteger;

public class TestPrimeNumbersV3 {

    public static BigInteger one = new BigInteger("1");
    public static BigInteger MinusOne = new BigInteger("-1");
    public static BigInteger two = new BigInteger ("2");
    public static BigInteger Trial = new BigInteger("20");
    public static void main(String[] args) {
        long st=System.currentTimeMillis();
        BigInteger n = new BigInteger("14044339361799042077");
        BigInteger minus = n.add(MinusOne);
        BigInteger Zero = new BigInteger("0");
        BigInteger BigModulo = Zero;
        BigInteger r = Zero;
        double v;
        boolean Prime = true;
        while (!BigModulo.equals(BigInteger.ONE)) {
            minus = minus.divide(two);
            BigModulo = minus.mod(two);
            r = r.add(one);
        }
        System.out.println("n-1 = 2 to the power of " + r + " times " + minus);
        for (BigInteger i = one;
             i.compareTo(Trial) <= 0;
             i = i.add(one)) {
            if(!MillerTest(minus, r, i, n)) {
                System.out.println("Not a prime");
                Prime = false;
            }

        }
        if (Prime) {
            v = Trial.doubleValue();
            v = 1 - Math.pow(4.0,-v);
            System.out.println("You have " + v + "% chance of the number being prime");
        }
        long en=System.currentTimeMillis();
        en = en-st;
        System.out.println("It took " + en + "ms to find the result");
    }

    public static boolean MillerTest(BigInteger d, BigInteger r, BigInteger Witness,BigInteger n) {
        BigInteger Power = Witness.modPow(d,n);
        BigInteger Exponent;
        BigInteger SecondTest;
        int v;
        Boolean TEST2 = false;
        for (BigInteger i =  new BigInteger("0");
             i.compareTo(r) <= 0;
             i = i.add(one)) {
            v = i.intValueExact();
            Exponent = two.pow(v);
            Exponent = Exponent.multiply(d);
            SecondTest = Witness.modPow(Exponent,n);
            if (SecondTest.equals(n.add(MinusOne))) TEST2 = true;
        }
        if (Power.equals(one)) return true;
        else if (TEST2) return true;
        else return false;


    }


}
