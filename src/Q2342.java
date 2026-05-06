import java.util.Scanner;

public class Q2342 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = 0, S = 1;

        int DP[][][] = new int[100001][5][5];
        int MP[][] = { { 0, 2, 2, 2, 2 },
                       { 2, 1, 3, 4, 3 },
                       { 2, 3, 1, 3, 4 },
                       { 2, 4, 3, 1, 3 },
                       { 2, 3, 4, 3, 1 }};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 100001; k++) {
                    DP[k][i][j] = 100001 + 4;
                }
            }
        }

        DP[0][0][0] = 0;
        while (true) {
            N = sc.nextInt();
            if (N == 0) {
                break;
            }

            for (int i = 0; i < 5; i++) {
                if (N == i) {
                    continue;
                }
                for (int j = 0; j < 5; j++) {
                    DP[S][i][N] = Math.min(DP[S - 1][i][j] + MP[j][N], DP[S][i][N]);
                }
            }

            for (int j = 0; j < 5; j++) {
                if (N == j) {
                    continue;
                }
                for (int i = 0; i < 5; i++) {
                    DP[S][N][i] = Math.min(DP[S - 1][i][j] + MP[i][N], DP[S][N][j]);
                }
            }
            S++;
        }
        S--;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, DP[S][i][j]);
            }
        }
        System.out.println(min);
    }
}
