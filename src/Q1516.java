import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1516 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];
        int[] time = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1) {
                    break;
                }
                A.get(temp).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : A.get(now)) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + time[now]);
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + time[i]);
        }
    }
}
