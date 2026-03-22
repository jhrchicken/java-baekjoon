import java.util.Scanner;

public class Q2023 {
    static int n;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int num, int digit) {
        if (digit == n) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, digit + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}