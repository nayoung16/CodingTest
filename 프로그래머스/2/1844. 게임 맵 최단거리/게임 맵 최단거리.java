import java.util.*;

class Solution {
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,-1,1};
    int[][] maps;
    int n;
    int m;
    
    class Node {
        int y;
        int x;
        int count;
        
        Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    public int bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new Node(0,0,1));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int y = cur.y;
            int x = cur.x;
            int count = cur.count;
            
            if (y == n-1 && x == m-1) {
                return count;
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0 <= ny && ny < n && 0 <= nx && nx < m && maps[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new Node(ny,nx,count+1));
                }
            }
        }
        return -1;
    }

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        this.maps = maps;
        return bfs();
    }
}