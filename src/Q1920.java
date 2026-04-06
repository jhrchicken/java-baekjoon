import java.util.Arrays;
import java.util.Scanner;

public class Q1920 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            boolean isExist = false;
            int start = 0;
            int end = N - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (A[mid] > target) {
                    end = mid - 1;
                }
                else if (A[mid] < target) {
                    start = mid + 1;
                }
                else {
                    isExist = true;
                    break;
                }
            }

            if (isExist) {
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }
        }
    }
}
