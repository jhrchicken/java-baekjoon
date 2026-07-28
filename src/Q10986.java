import java.util.Scanner;

public class Q10986 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] S = new int[N + 1];
        int[] C = new int[M];
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            // 입력을 받으면서 수열 합 배열에 % 연산 수행
            S[i] = (S[i - 1] + sc.nextInt()) % M;
            // 구간 합 자체가 0일 때 answer에 더하기
            if (S[i] == 0) {
                answer++;
            }
            // 나머지가 같은 인덱스의 개수 카운팅
            C[S[i]]++;
        }

        // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 answer에 더하기
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer += (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}
