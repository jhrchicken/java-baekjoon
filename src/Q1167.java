import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1167 {
    static boolean visited[];
    static int[] distance;
    static ArrayList<Edge>[] A;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            while (true) {
                int E = sc.nextInt();
                if (E == -1) {
                    break;
                }
                int V = sc.nextInt();
                A[S - 1].add(new Edge(E - 1, V));
            }
        }

        distance = new int[N];
        visited = new boolean[N];
        BFS(0);

        int max = 0;
        for (int i = 1; i < N; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        distance = new int[N];
        visited = new boolean[N];
        BFS(max);

        Arrays.sort(distance);
        System.out.println(distance[N - 1]);
    }

    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Edge i : A[now]) {
                int e = i.e;
                int v = i.value;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now] + v;
                }
            }
        }
    }
}

class Edge {
    int e;
    int value;

    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}