import java.io.*;
import java.util.StringTokenizer;

public class Q1517 {
    public static int[] A, B;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        mergeSort(0, N - 1);
        System.out.println(result);
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int mid = start + (end - start) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        for (int i = start; i <= end; i++) {
            B[i] = A[i];
        }

        int k = start;
        int i = start;
        int j = mid + 1;
        while(i <= mid && j <= end) {
            if (B[i] > B[j]) {
                A[k++] = B[j++];
                result += j - k;
            }
            else {
                A[k++] = B[i++];
            }
        }
        while (i <= mid) {
            A[k++] = B[i++];
        }
        while (j <= end) {
            A[k++] = B[j++];
        }
    }
}
