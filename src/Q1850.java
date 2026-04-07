import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q1850 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long A = sc.nextLong();
        long B = sc.nextLong();

        long result = gcd(A, B);
        for (int i = 0; i < result; i++) {
            bw.write("1");
        }
        bw.flush();
        bw.close();
    }

    public static long gcd(long A, long B) {
        if (B == 0) {
            return A;
        }
        else {
            return gcd(B, A % B);
        }
    }
}
