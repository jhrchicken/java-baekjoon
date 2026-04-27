import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11725 {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer> tree[];
    static int answer[];


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            tree[num1].add(num2);
            tree[num2].add(num1);
        }

        DFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }

    }

    public static void DFS(int num) {
        visited[num] = true;
        for (int i: tree[num]) {
            if (!visited[i]) {
                answer[i] = num;
                DFS(i);
            }
        }
    }
}
