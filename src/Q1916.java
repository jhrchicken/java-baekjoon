import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1916 {
    public static int N, M;
    public static int[] distance;
    public static boolean[] visited;
    public static ArrayList<Node> list[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        bw.write(dijkstra(startIndex, endIndex) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentIndex = currentNode.index;
            if (!visited[currentIndex]) {
                visited[currentIndex] = true;
                for (Node node : list[currentIndex]) {
                    if (!visited[node.index] && distance[node.index] > distance[currentIndex] + node.value) {
                        distance[node.index] = distance[currentIndex] + node.value;
                        queue.add(new Node(node.index, distance[node.index]));
                    }
                }
            }
        }

        return distance[end];
    }
}
