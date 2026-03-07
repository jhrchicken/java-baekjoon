import java.util.Scanner;

public class Q11659 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int S[] = new int[M + 1];
        S[0] = 0;
        for (int i = 1; i <= M; i++) {
            int num = sc.nextInt();
            S[i] = S[i - 1] + num;
        }

        for (int k = 0; k < N; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(S[j] - S[i - 1]);
        }
    }
}
