import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2252 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            A.get(start).add(end);
            indegree[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now + " ");
            for (int next : A.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
