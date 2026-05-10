import java.util.Scanner;

public class Q17387 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[][] L = new int[4][2];
        int[] ccw = new int[4];

        for (int i = 0; i < 4; i++) {
            L[i][0] = sc.nextInt();
            L[i][1] = sc.nextInt();
        }

        boolean answer = isCross(L[0][0], L[0][1], L[1][0], L[1][1], L[2][0], L[2][1], L[3][0], L[3][1]);
        if (answer) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }

    }

    private static int ccw (int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
    }

    private static boolean isOverlab(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
                && Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2)) {
            return true;
        }
        return false;
    }

    private static boolean isCross(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int abc = ccw(x1, y1, x2, y2, x3, y3);
        int abd = ccw(x1, y1, x2, y2, x4, y4);
        int cda = ccw(x3, y3, x4, y4, x1, y1);
        int cdb = ccw(x3, y3, x4, y4, x2, y2);

        if (abc * abd == 0 && cda * cdb == 0) {
            return isOverlab(x1, y1, x2, y2, x3, y3, x4, y4);
        }
        else if (abc * abd < 0 && cda * cdb < 0) {
            return true;
        }
        return false;
    }
}
