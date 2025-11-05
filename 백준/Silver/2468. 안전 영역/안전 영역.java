import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int max_h = 0;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int t = Integer.parseInt(st.nextToken());
                board[i][j] = t;
                if (t > max_h) max_h = t;
            }
        }
        int max = 0;
        for (int rain = 0; rain < max_h; rain++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = false;
                }
            }
            int checked = check(rain);
            max = Math.max(max, checked);
        }
        System.out.println(max);
    }

    public static int check(int rain) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > rain && !visited[i][j]) {
                    bfs(i, j, rain);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(int y, int x, int rain) {
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k];
                int nx = cur[1] + dx[k];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (board[ny][nx] > rain && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx});
                }
            }
        }

    }
}
