import java.io.*;
import java.util.*;

public class Main {

    static int k,w,h;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] horse_moves = {{-2,-1},{-2,+1},{+2,-1},{+2,+1},{-1,2},{1,-2},{-1,-2},{1,2}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        graph = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[h][w][k + 1];
        System.out.println(bfs(0,0));
    }

    private static int bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        // {y,x,horseUsed,dist}
        q.offer(new int[]{y,x,0,0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (visited[cur[0]][cur[1]][cur[2]]) continue;
            visited[cur[0]][cur[1]][cur[2]] = true;
            if (cur[0] == h-1 && cur[1] == w-1) {
                return cur[3];
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (0 <= ny && ny < h && 0 <= nx && nx < w) {
                    if (graph[ny][nx] == 0 && !visited[ny][nx][cur[2]]) {
                        q.add(new int[]{ny, nx, cur[2], cur[3] + 1});
                    }
                }
            }
            if (cur[2] < k) {
                for (int[] move : horse_moves) {
                    int ny = cur[0] + move[0];
                    int nx = cur[1] + move[1];
                    if (0 <= ny && ny < h && 0 <= nx && nx < w) {
                        int nextUsed = cur[2] + 1;
                        if (graph[ny][nx] == 0 && !visited[ny][nx][nextUsed]) {
                            q.add(new int[]{ny, nx, nextUsed, cur[3] + 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}