package fr.group11.prime;
import java.math.BigInteger;
import java.util.Scanner;
public class TestPrimeNumbers {
    public static int alpha;
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        long start = System.currentTimeMillis();
        boolean t=Test(a);
        long end = System.currentTimeMillis();
        System.out.println("It is "+t+" It took "+(end-start)+" ms ");
        System.out.println(alpha);


    }
    public static boolean Test( BigInteger n) {
        BigInteger st =n.sqrt();
        alpha+=1;
        for (BigInteger i = BigInteger.valueOf(2);
             i.compareTo(st) <= 0;
             i = i.add(BigInteger.ONE)) {
            alpha++;
            if(n.mod(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }
}
