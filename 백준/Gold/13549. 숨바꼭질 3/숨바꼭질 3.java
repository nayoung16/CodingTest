import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<Integer> dq = new ArrayDeque<>();

        dist[n] = 0;
        dq.add(n);

        while (!dq.isEmpty()) {
            int x = dq.pollFirst();

            if (x == k) {
                System.out.println(dist[x]);
                return;
            }
            
            int nx = x * 2;
            if (nx <= MAX && dist[nx] > dist[x]) {
                dist[nx] = dist[x];
                dq.addFirst(nx);
            }

            nx = x - 1;
            if (nx >= 0 && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }

            nx = x + 1;
            if (nx <= MAX && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }
        }
    }

}