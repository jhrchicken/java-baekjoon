import java.util.Scanner;

public class Q11659 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int S[] = new int[N + 1];
        S[0] = 0;
        for (int i = 0; i < N; i++) {
            S[i + 1] = S[i] + sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(S[end] - S[start - 1]);
        }
    }
}