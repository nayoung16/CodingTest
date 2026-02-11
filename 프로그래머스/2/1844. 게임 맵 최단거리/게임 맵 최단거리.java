import java.util.*;

class Solution {
    
    static class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length; //세로
        int m = maps[0].length; //가로
        
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        boolean[][] visited = new boolean[n][m];
        Node node = new Node(0,0);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        visited[0][0] = true;
        
        if (maps[0][0] == 0) return -1;
        
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i<4; i++) {
                int nx = curNode.x+dx[i];
                int ny = curNode.y+dy[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (maps[ny][nx] == 0 || visited[ny][nx]) continue;
                
                maps[ny][nx] = maps[curNode.y][curNode.x] + 1;
                
                visited[ny][nx] = true;
                queue.add(new Node(nx,ny));
                
            }
        }
        return visited[n-1][m-1] ? maps[n-1][m-1] : -1;
    }
}