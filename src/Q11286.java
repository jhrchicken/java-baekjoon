import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q11286 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
           int o1_abs =  Math.abs(o1);
           int o2_abs = Math.abs(o2);
           if (o1_abs == o2_abs) {
               return o1 > o2 ? 1 : -1;
           }
           else {
               return o1_abs - o2_abs;
           }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(bf.readLine());
            if (x == 0) {
                if (queue.isEmpty()) {
                    System.out.println("0");
                }
                else {
                    System.out.println(queue.poll());
                }
            }
            else {
                queue.add(x);
            }
        }
    }
}
