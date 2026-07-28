import java.util.Scanner;

public class Q2018 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 1;
        int count = 1;
        int startIdx = 1;
        int endIdx = 1;

        while (endIdx != N) {
            if (sum == N) {
                count++;
                endIdx++;
                sum += endIdx;
            }
            else if (sum < N) {
                endIdx++;
                sum += endIdx;
            }
            else {
                sum -= startIdx;
                startIdx++;
            }
        }

        System.out.println(count);
    }
}