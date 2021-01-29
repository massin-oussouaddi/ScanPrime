package fr.group11.prime;
import java.util.Scanner;
public class TestPrimeNumbersV2 {
    public static int alpha = 0;
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int limit = Sc.nextInt();
        long a = System.currentTimeMillis();
        int[] Values = Sieve(limit);
        int number = 0;
        for (int i = 0; i < Values.length; i++) {
            if (Values[i] != 0) {
                System.out.println(Values[i]);
                number++;
            }
        }
        long b = System.currentTimeMillis();
        System.out.println("There are " + number + " prime numbers between 1 and " + limit);
        System.out.println(b - a + " ms");
        System.out.println("nb of operations"+alpha);
    }

    public static int[] Sieve(int limit) {
        int[] Values = new int[limit];
        for (int i = 0; i < Values.length; i++) {
            Values[i] = i;
        }
        Values[1] = 0;
        for (int i = 2; i < Math.sqrt(limit); i++) {
            for (int j = i * i; j < limit; j += i) {
                Values[j] = 0;
            }
            alpha+=1;
        }
        return Values;
    }
}