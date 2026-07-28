import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1253 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            int startIdx = 0;
            int endIdx = i - 1;
            while (startIdx < endIdx) {
                if (A[startIdx] + A[endIdx] == A[i]) {
                    count++;
                    break;

                }
                else if (A[startIdx] + A[endIdx] < A[i]) {
                    endIdx--;
                }
                else {
                    startIdx++;
                }
            }
        }
        System.out.println(count);
    }
}
