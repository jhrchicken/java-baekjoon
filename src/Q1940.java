import java.util.Arrays;
import java.util.Scanner;

public class Q1940 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int count = 0;
        int start_index = 0;
        int end_index = N - 1;

        while (start_index < end_index) {
            if (A[start_index] + A[end_index] < M) {
                start_index++;
            }
            else if (A[start_index] + A[end_index] > M) {
                end_index--;
            }
            else {
                count++;
                start_index++;
                end_index--;
            }
        }

        System.out.println(count);
    }
}
