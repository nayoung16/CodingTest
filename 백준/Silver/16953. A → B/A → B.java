import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bfs(a,b);
    }

    public static void bfs(int a, int b) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,1});
        visited.add(a);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curA = cur[0];
            int count = cur[1];

            if (curA == b) {
                System.out.println(count);
                return;
            }

            long t = (long) curA * 2;
            if ( t <= b) {
                int timeCur = (int)t;
                if (!visited.contains(timeCur)) {
                    visited.add(timeCur);
                    q.add(new int[]{timeCur,count+1});
                }
            }

            long t2 = (long) curA * 10 + 1;
            if (t2 <= b) {
                int addCur = (int) t2;
                if (!visited.contains(addCur)) {
                    visited.add(addCur);
                    q.add(new int[]{addCur, count+1});
                }
            }
        }
        System.out.println(-1);
    }
}