import java.util.*;

class Solution {
    static final int MAX = 105;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[MAX][MAX];
        boolean[][] visited = new boolean[MAX][MAX];
        
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    board[y][x] = 1;
                }
            }
        }
        
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            for (int y = y1+1; y <= y2-1; y++) {
                for (int x = x1+1; x <= x2-1; x++) {
                    board[y][x] = 0;
                }
            }
        }
        
        int sx = characterX * 2;
        int sy = characterY * 2;
        int tx = itemX * 2;
        int ty = itemY * 2;
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sy,sx,0});
        visited[sy][sx] = true;
        
        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            int y = cur[0], x = cur[1], d = cur[2];
            
            if (x == tx && y == ty) {
                return d/2;
            }
            for (int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < MAX && 0 <= ny && ny < MAX) {
                    if (!visited[ny][nx] && board[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        dq.add(new int[]{ny, nx, d+1});
                    }
                }
            }
        }
        return -1;
    }
}