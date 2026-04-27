import java.util.ArrayList;
import java.util.Scanner;

public class Q1068 {
    static boolean visited[];
    static ArrayList<Integer> tree[];
    static int answer = 0;
    static int deleteNode;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        visited = new boolean[N];
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        int root = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num != -1) {
                tree[num].add(i);
                tree[i].add(num);
            }
            else {
                root = i;
            }
        }

        deleteNode = sc.nextInt();
        if (deleteNode == root) {
            System.out.println(0);
        }
        else {
            DFS(root);
            System.out.println(answer);
        }
    }

    public static void DFS(int num) {
        visited[num] = true;
        int childNode = 0;

        if (tree[num].isEmpty()) {
            answer++;
        }
        for (int i : tree[num]) {
            if (!visited[i] && i != deleteNode) {
                childNode++;
                DFS(i);
            }
        }

        if (childNode == 0) {
            answer++;
        }
    }
}
