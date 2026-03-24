import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {
    static boolean visited[];
    static ArrayList<Integer>[] A;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S - 1].add(E - 1);
            A[E - 1].add(S - 1);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N];
        DFS(V - 1);
        System.out.println();

        visited = new boolean[N];
        BFS(V - 1);
    }

    private static void DFS(int node) {
        System.out.print(node + 1 + " ");
        visited[node] = true;
        for (int i : A[node]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int nowNode = queue.poll();
            System.out.print(nowNode + 1 + " ");
            for (int i : A[nowNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
