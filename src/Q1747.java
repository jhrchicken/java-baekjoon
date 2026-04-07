import java.util.Scanner;

public class Q1747 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[] prime = new boolean[10000001];
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            if (!prime[i]) {
                continue;
            }
            for (int j = i + i; j < prime.length; j += i) {
                prime[j] = false;
            }
        }

        while (true) {
            if (prime[N]) {
                if (isPalindrome(N)) {
                    System.out.println(N);
                    break;
                }
            }
            N++;
        }
    }

    private static boolean isPalindrome(int num) {
        char temp[] = String.valueOf(num).toCharArray();
        int start = 0;
        int end = temp.length - 1;
        while (start < end) {
            if (temp[start] != temp[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
