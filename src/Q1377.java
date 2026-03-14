import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Q1377 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Node[] A = new Node[N];
        for (int i = 0; i < N; i++) {
            A[i] = new Node(i, Integer.parseInt(bf.readLine()));
        }
        Arrays.sort(A);

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < A[i].index - i) {
                max = A[i].index - i;
            }
        }
        System.out.println(max + 1);
    }
}

class Node implements Comparable<Node> {
    int index;
    int value;

    Node (int index, int value) {
        super();
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}