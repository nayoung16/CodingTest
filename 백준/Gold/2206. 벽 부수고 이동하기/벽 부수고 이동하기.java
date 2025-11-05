import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static char[][] map;
    static boolean[][][] visited;
    // 상 하 좌 우
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};

    static class Node {
        int y;
        int x;
        int cnt;
        boolean destroyed;

        public Node(int y, int x, int cnt, boolean destroyed) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                visited[i][j][0] = false;
                visited[i][j][1] = false;
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, false));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.y == n - 1 && cur.x == m - 1) {
                System.out.println(cur.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                int next_cnt = cur.cnt + 1;
                if (map[ny][nx] == '0') {
                    if (!cur.destroyed && !visited[ny][nx][0]) { // 여태까지 부신 벽이 없었다면
                        q.add(new Node(ny, nx, next_cnt, false));
                        visited[ny][nx][0] = true;
                    }
                    else if (cur.destroyed && !visited[ny][nx][1]) { // 벽 부신 적 있었다면
                        q.add(new Node(ny, nx, next_cnt, true));
                        visited[ny][nx][1] = true;
                    }
                } else if (map[ny][nx] == '1') { // 벽이면
                    if (!cur.destroyed) { // 부신 적 없다면 부시기
                        q.add(new Node(ny, nx, next_cnt, true));
                        visited[ny][nx][1] = true;
                    }
                }
            }

        }

        System.out.println(-1);
    }
}