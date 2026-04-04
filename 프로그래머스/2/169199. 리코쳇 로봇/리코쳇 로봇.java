import java.util.*;

class Solution {
    
    public char[][] graph;
    public int[] dy = {-1,1,0,0};
    public int[] dx = {0,0,-1,1};
    public int startX = 0;
    public int startY = 0;
    public int n, m;
    public boolean[][] visited;
    
    public int bfs() {
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{startY, startX, 0});
        visited[startY][startX] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            int dist = cur[2];

            if (graph[cy][cx] == 'G') {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy;
                int nx = cx;

                while (true) {
                    int ty = ny + dy[i];
                    int tx = nx + dx[i];

                    if (ty < 0 || ty >= n || tx < 0 || tx >= m || graph[ty][tx] == 'D') {
                        break;
                    }

                    ny = ty;
                    nx = tx;
                }

                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx, dist + 1});
                }
            }
        }

        return -1;
    }
    
    public int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        graph = new char[n][m];
        
        // graph init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = board[i].charAt(j);
                if (graph[i][j] == 'R') {
                    startY = i;
                    startX = j;
                }
            }
        }
        
        visited = new boolean[n][m];
        
        answer = bfs();
        
        return answer;
    }
}