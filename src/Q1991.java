import java.util.Scanner;

public class Q1991 {
    static int[][] tree;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        tree = new int[26][2];
        for (int i = 0; i < N; i++) {
            String[] temp = sc.nextLine().split(" ");
            int node = temp[0].charAt(0) - 'A';

            if (temp[1].charAt(0) == '.') {
                tree[node][0] = -1;
            }
            else {
                tree[node][0] = temp[1].charAt(0) - 'A';
            }

            if (temp[2].charAt(0) == '.') {
                tree[node][1] = -1;
            }
            else {
                tree[node][1] = temp[2].charAt(0) - 'A';
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    public static void preOrder(int node) {
        if (node == -1) {
            return;
        }
        System.out.print((char) (node + 'A'));
        preOrder(tree[node][0]);
        preOrder(tree[node][1]);
    }

    public static void inOrder(int node) {
        if (node == -1) {
            return;
        }
        inOrder(tree[node][0]);
        System.out.print((char) (node + 'A'));
        inOrder(tree[node][1]);
    }

    public static void postOrder(int node) {
        if (node == -1) {
            return;
        }
        postOrder(tree[node][0]);
        postOrder(tree[node][1]);
        System.out.print((char) (node + 'A'));
    }
}
