import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1940 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int startIdx = 0;
        int endIdx = N - 1;
        int count = 0;
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        while (startIdx < endIdx) {
            if (A[startIdx] + A[endIdx] == M) {
                count++;
                startIdx++;
                endIdx--;
            }
            else if (A[startIdx] + A[endIdx] < M) {
                startIdx++;
            }
            else {
                endIdx--;
            }
        }
        System.out.println(count);
    }
}