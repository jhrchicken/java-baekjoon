import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1744 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();
            if (data > 1) {
                plus.add(data);
            }
            else if (data == 1) {
                one++;
            }
            else if (data == 0) {
                zero++;
            }
            else {
                minus.add(data);
            }
        }

        int sum = 0;
        while (plus.size() > 1) {
            int first = plus.remove();
            int second = plus.remove();
            sum += (first * second);
        }
        if (!plus.isEmpty()) {
            sum += plus.remove();
        }

        while (minus.size() > 1) {
            int first = minus.remove();
            int second = minus.remove();
            sum += (first * second);
        }
        if (!minus.isEmpty()) {
            if (zero == 0) {
                sum += minus.remove();
            }
        }

        sum += one;
        System.out.println(sum);
    }
}
