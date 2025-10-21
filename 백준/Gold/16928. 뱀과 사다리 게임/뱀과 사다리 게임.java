import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ladder = new int[101]; // 따라 올라감
        int[] snake = new int[101]; // 따라 내려감
        boolean[] visited = new boolean[101];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladder[x] = y;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            snake[u] = v;
        }

        System.out.println(bfs(1, ladder, snake, visited));
    }

    static int bfs(int start, int[] ladder, int[] snake, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start, 0}); // {현재 위치, 주사위 횟수}
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int pos = now[0];
            int cnt = now[1];

            if (pos == 100) return cnt;

            for (int i=1; i<7; i++) {
                int next = pos + i;
                if (next > 100) continue;

                if (ladder[next] != 0) next = ladder[next];
                else if (snake[next] != 0) next = snake[next];

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cnt+1});
                }
            }
        }
        return -1;
    }

}
