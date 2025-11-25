import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] graph;
    static int count, result;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;
        result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    int curArea = dfs(i,j);
                    count++;
                    result = Math.max(result, curArea);
                }
            }
        }

        System.out.println(count);
        System.out.println(result);
    }

    private static int dfs(int y, int x) {
        graph[y][x] = 0;
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (0 <= ny && ny < n && 0 <= nx && nx < m && graph[ny][nx] == 1) {
                area += dfs(ny, nx);
            }
        }
        return area;
    }

}