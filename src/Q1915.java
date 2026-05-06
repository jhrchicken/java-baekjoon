import java.util.Scanner;

public class Q1915 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[][] D = new long[N + 1][M + 1];
        long max = 0;
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                D[i][j] = Long.parseLong(String.valueOf(str.charAt(j)));
                if (D[i][j] == 1 && i > 0 && j > 0) {
                    D[i][j] = Math.min(D[i - 1][j - 1], Math.min(D[i][j - 1], D[i - 1][j])) + D[i][j];
                }
                if (max < D[i][j]) {
                    max = D[i][j];
                }
            }
        }

        System.out.println(max * max);
    }
}
