import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11438 {
    static int N, M;
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int kmax;
    static int[][] parent;
    static boolean[] visited;

    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        depth = new int[N + 1];
        visited = new boolean[N + 1];

        // 최대 가능 depth 구하기
        int temp = 1;
        kmax = 0;
        while (temp <= N) {
            temp <<= 1;
            kmax++;
        }

        parent = new int[kmax + 1][N + 1];
        BFS(1);
        for (int k = 1; k <= kmax; k++) {
            for (int n = 1; n <= k; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(findLCA(a, b));
        }
    }

    static int findLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int k = kmax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }
        for (int k = kmax; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int LCA = a;
        if (a != b) {
            LCA = parent[0][LCA];
        }
        return LCA;
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;
        depth[node] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int next : tree[currentNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[0][next] = currentNode;
                    depth[next] = depth[currentNode] + 1;
                }
            }
        }
    }
}
