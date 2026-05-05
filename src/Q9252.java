import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q9252 {
    private static char[] A;
    private static char[] B;
    private static long[][] D;
    private static ArrayList<Character> path;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
        D = new long[A.length + 1][B.length + 1];
        path = new ArrayList<Character>();
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    D[i][j] = D[i - 1][j - 1] + 1;
                }
                else {
                    D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
                }
            }
        }
        System.out.println(D[A.length][B.length]);

        getText(A.length, B.length);
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    private static void getText(int r, int c) {
        if (r == 0 || c == 0) {
            return;
        }

        if (A[r - 1] == B[c - 1]) {
            path.add(A[r - 1]);
            getText(r - 1, c - 1);
        }
        else {
            if (D[r - 1][c] > D[r][c - 1]) {
                getText(r - 1, c);
            }
            else {
                getText(r, c - 1);
            }
        }
    }
}
