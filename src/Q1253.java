import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1253 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long A[] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        int count = 0;
        for (int k = 0; k < N; k++) {
            int start_index = 0;
            int end_index = N - 1;
            while (start_index < end_index) {
                if (A[start_index] + A[end_index] == A[k]) {
                    if (start_index != k && end_index != k) {
                        count++;
                        break;
                    }
                    else if (start_index == k) {
                        start_index++;
                    }
                    else if (end_index == k) {
                        end_index--;
                    }
                }
                else if (A[start_index] + A[end_index] < A[k]) {
                    start_index++;
                }
                else if (A[start_index] + A[end_index] > A[k]) {
                    end_index--;
                }
            }
        }

        System.out.println(count);
    }
}
