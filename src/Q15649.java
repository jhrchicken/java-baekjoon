import java.util.Scanner;

public class Q15649 {
    static int N, M;
    static boolean V[];
    static int[] S;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = new boolean[N];
        S = new int[N];

        backtracking(0);
    }

    private static void backtracking(int length) {
        if (length == M) {
            printArray();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!V[i]) {
                V[i] = true;
                S[length] = i;
                backtracking(length + 1);
                V[i] = false;
            }
        }
    }

    private static void printArray() {
        for (int i = 0; i < M; i++) {
            System.out.print(S[i] + 1 + " ");
        }
        System.out.println();
    }
}
