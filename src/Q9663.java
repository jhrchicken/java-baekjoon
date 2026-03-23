import java.util.Scanner;

public class Q9663 {
    static int N;
    static int[] A;
    static int count = 0;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];

        backtracking(0);
        System.out.println(count);
    }

    private static void backtracking(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            A[row] = i;
            if (check(row)) {
                backtracking(row + 1);
            }
        }
    }

    private static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (A[i] == A[row]) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(A[i] - A[row])) {
                return false;
            }
        }
        return true;
    }
}
