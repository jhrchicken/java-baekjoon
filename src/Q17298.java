import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q17298 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                answer[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
