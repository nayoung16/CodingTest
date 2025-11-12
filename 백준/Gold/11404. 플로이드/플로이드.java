import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int u = a-1, v = b-1;
            if ( c < map[u][v] ) map[u][v] = c;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (map[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    if (map[k][j] == INF) continue;
                    int nd = map[i][k] + map[k][j];
                    if (nd < map[i][j]) map[i][j] = nd;
                }
            }
        }

       StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == INF) sb.append(0).append(" ");
                else sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
