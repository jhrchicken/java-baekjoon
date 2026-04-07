import java.util.Scanner;

public class Q1456 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        boolean[] prime = new boolean[10000001];
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (!prime[i]) {
                continue;
            }
            for (int j = i + i; j < prime.length; j += i) {
                prime[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (prime[i]) {
                long temp = i;
                while ((double)i <= (double)B / (double)temp) {
                    if ((double)i >= (double)A / (double)temp) {
                        count++;
                    }
                    temp *= i;
                }
            }
        }
        System.out.println(count);
    }
}
