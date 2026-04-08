import java.util.*;

public class Q18352 {
    static int distance[];
    static ArrayList<Integer>[] A;
    static int N, M, K, X;
    static List<Integer> answer;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            A[start].add(end);
        }

        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            distance[i] = -1;
        }

        BFS(X);
        answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            System.out.println("-1");
        }
        else {
            Collections.sort(answer);
            for (int temp : answer) {
                System.out.println(temp);
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        distance[node]++;

        while (!queue.isEmpty()) {
            int newNode = queue.poll();
            for (int i : A[newNode]) {
                if (distance[i] == -1) {
                    distance[i] = distance[newNode] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
