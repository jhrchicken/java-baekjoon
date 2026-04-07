import java.util.Scanner;

public class Q1929 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] A = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            A[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (A[i] == false) {
                continue;
            }
            for (int j = i + i; j <= N; j = j + i) {
                A[j] = false;
            }
        }

        for (int i = M; i < N; i++) {
            if (A[i]) {
                System.out.println(i);
            }
        }
    }
}
