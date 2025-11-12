import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = string.charAt(j);
            }
        }

        final int INF = 1000000;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'Y') dist[i][j] = 1;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    if (dist[k][j] == INF) continue;
                    int nd = dist[i][k] + dist[k][j];
                    if (nd < dist[i][j]) dist[i][j] = nd;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i==j) continue;
                if (dist[i][j] <= 2) cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
