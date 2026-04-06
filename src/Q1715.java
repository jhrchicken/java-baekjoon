import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1715 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(sc.nextInt());
        }

        int sum = 0;
        while (queue.size() != 1) {
            int card1 = queue.poll();
            int card2 = queue.poll();
            sum += (card1 + card2);
            queue.add(card1 + card2);
        }

        System.out.println(sum);
    }
}
