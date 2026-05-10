import java.util.Scanner;

public class Q11758 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int P[][] = new int[3][2];

        for (int i = 0; i < 3; i++) {
            P[i][0] = sc.nextInt();
            P[i][1] = sc.nextInt();
        }

        int result = (P[0][0] * P[1][1] + P[1][0] * P[2][1] + P[2][0] * P[0][1])
                - (P[1][0] * P[0][1] + P[2][0] * P[1][1] + P[0][0] * P[2][1]);

        if (result < 0) {
            System.out.println(-1);
        }
        else if (result == 0) {
            System.out.println(0);
        }
        else {
            System.out.println(1);
        }
    }
}
