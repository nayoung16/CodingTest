import java.util.*;

class Solution {
    static int h, w;
    static int[][] board;     
    static boolean[][] vis;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        h = maps.length;
        w = maps[0].length();
        board = new int[h][w];
        vis = new boolean[h][w];

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                char c = maps[y].charAt(x);
                if (c == 'X') board[y][x] = -1;
                else board[y][x] = c - '0';
            }
        }

        List<Integer> sums = new ArrayList<>();
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (!vis[y][x] && board[y][x] != -1) {
                    sums.add(bfs(y, x));
                }
            }
        }

        if (sums.isEmpty()) return new int[]{-1};
        Collections.sort(sums);
        int[] answer = new int[sums.size()];
        for (int i = 0; i < sums.size(); i++) answer[i] = sums.get(i);
        return answer;
    }

    private int bfs(int sy, int sx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sy, sx});
        vis[sy][sx] = true;

        int sum = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];
            sum += board[y][x];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if (vis[ny][nx]) continue;
                if (board[ny][nx] == -1) continue; // 바다
                vis[ny][nx] = true;
                q.offer(new int[]{ny, nx});
            }
        }
        return sum;
    }
}