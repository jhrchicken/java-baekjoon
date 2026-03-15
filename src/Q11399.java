import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11399 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int temp = P[i];
            int j = i;
            while ((j > 0) && (P[j - 1] > temp)) {
                P[j] = P[j - 1];
                j--;
            }
            P[j] = temp;
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += P[i] * (N - i);
        }

        System.out.println(sum);
    }
}