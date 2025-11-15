import java.io.*;
import java.util.*;

public class Main {
    static int total;
    static boolean[][] visited = new boolean[1501][1501];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        total = a + b + c;
        if (total % 3 != 0) {
            System.out.println(0);
            return;
        }

        bfs(a,b,c);
    }

    static void bfs(int a, int b, int c) {
        Queue<int[]> q = new LinkedList<>();

        int[] arr = {a,b,c};
        Arrays.sort(arr);
        visited[arr[0]][arr[1]] = true;
        q.add(arr);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int z = cur[2];

            if (x == y && y == z) {
                System.out.println(1);
                return;
            }
            tryNext(x,y,z,q);
            tryNext(y,z,x,q);
            tryNext(z,x,y,q);
        }
        System.out.println(0);
    }

    static void tryNext(int a, int b, int c, Queue<int[]> q) {
        if (a == b) return;

        int small = Math.min(a,b);
        int big = Math.max(a,b);

        int newSmall = small * 2;
        int newBig = big - small;
        int newC = c;

        int[] next = {newSmall, newBig, newC};
        Arrays.sort(next);

        int x = next[0];
        int y = next[1];
        if (!visited[x][y]) {
            visited[x][y] = true;
            q.add(next);
        }
    }



}