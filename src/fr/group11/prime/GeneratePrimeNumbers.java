package fr.group11.prime;

import java.math.BigInteger;
import java.util.Random;

public class GeneratePrimeNumbers {
    public static BigInteger one = new BigInteger("1");
    public static BigInteger MinusOne = new BigInteger("-1");
    public static BigInteger two = new BigInteger ("2");
    public static int C = 0;
    public static BigInteger Trial = new BigInteger("20");

    public static void main(String[] args) {

        int a = 0;
        while (a == 0) {
            BigInteger n = generation(2048);
            System.out.println(n);
            if (LPN(n)){
                if(Miller(n)){
                    a = 1;
                }
            }
        }


    }
    public static boolean Miller(BigInteger n){
        long st=System.currentTimeMillis();
        BigInteger minus = n.add(MinusOne);
        C++;
        BigInteger Zero = new BigInteger("0");
        BigInteger BigModulo = Zero;
        BigInteger r = Zero;
        double v;
        boolean Prime = true;
        while (!BigModulo.equals(BigInteger.ONE)) {
            minus = minus.divide(two);
            BigModulo = minus.mod(two);
            r = r.add(one);
            C+=3;
        }
        for (BigInteger i = one;
             i.compareTo(Trial) <= 0;
             i = i.add(one)) {
            C++;
            if(!MillerTest(minus, r, i, n)) {
                System.out.println("Not a prime");
                return  false;
            }

        }
        if (Prime) {
            v = Trial.doubleValue();
            v = 1 - Math.pow(4.0,-v);
            v *= 100;
            System.out.println("You have " + v + "% chance of the number being prime");
        }
        long en=System.currentTimeMillis();
        en = en-st;
        System.out.println("It took " + en + "ms to find the result with " + C + " operations");
        return true;
    }

    public static BigInteger generation(long n) {
        BigInteger maxLimit = new BigInteger("3231700607131100730071487668866995196044410266971548403213034542752465513886789089319720141152291346368871796092189801949411955915049092109508815238644828312063087736730099609175019775038965210679605763838406756827679221864261975616183809433847617047058164585203630504288757589154106580860755239912393038552191433338966834242068497478656456949485617603532632205807780565933102619270846031415025859285");
        BigInteger minLimit = new BigInteger("1615850303565550365035743834433497598022205133485774201606517271376232756943394544659860070576145673184435898046094900974705977957524546054754407619322414156031543868365049804587509887519482605339802881919203378413839610932130987808091904716923808523529082292601815252144378794577053290430377619956196519276095716669483417121034248739328228474742808801766316102903890282966551309635423015707512929644");
        BigInteger bigInteger = maxLimit.subtract(minLimit);
        Random randNum = new Random();
        int len = maxLimit.bitLength();
        BigInteger res = new BigInteger(len, randNum);
        if (res.compareTo(minLimit) < 0)
            res = res.add(minLimit);
        if (res.compareTo(bigInteger) >= 0)
            res = res.mod(bigInteger).add(minLimit);
        return res;
    }

    public static boolean LPN(BigInteger n ) {
        long[] tab = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67,
                71, 73, 79, 83, 89, 97, 101, 103,
                107, 109, 113, 127, 131, 137, 139,
                149, 151, 157, 163, 167, 173, 179,
                181, 191, 193, 197, 199, 211, 223,
                227, 229, 233, 239, 241, 251, 257,
                263, 269, 271, 277, 281, 283, 293,
                307, 311, 313, 317, 331, 337, 347, 349};
        for(int i = 0; i < tab.length; i++) {
            if (n.mod(BigInteger.valueOf(tab[i])).compareTo(BigInteger.ZERO) == 0) {
                return false;
            }
        }
        return true;

    }



    public static boolean MillerTest(BigInteger d, BigInteger r, BigInteger Witness,BigInteger n) {
        BigInteger Power = Witness.modPow(d,n);
        C+=2;
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
            C+=5;
        }
        if (Power.equals(one)) return true;
        else if (TEST2) return true;
        else return false;



    }
}