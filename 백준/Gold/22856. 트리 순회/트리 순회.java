import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] left, right, parent;
    static int last;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        left = new int[N + 1];
        right = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            left[a] = b;
            right[a] = c;
            if (b != -1) parent[b] = a;
            if (c != -1) parent[c] = a;
        }

        int root = 1;
        for (int i = 1; i <= N; i++) {
            if (parent[i] == 0) {
                root = i;
                break;
            }
        }

        inorder(root);

        long totalMoves = 2L * (N - 1);

        int dist = distanceToRoot(last);

        long answer = totalMoves - dist;
        System.out.println(answer);
    }

    static void inorder(int cur) {
        if (cur == -1) return;
        inorder(left[cur]);
        last = cur;
        inorder(right[cur]);
    }

    static int distanceToRoot(int node) {
        int d = 0;
        while (parent[node] != 0) {
            d++;
            node = parent[node];
        }
        return d;
    }
}