import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = string.charAt(j);
            }
        }
        int answer = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int dx = -n; dx <= n; dx++) {
                    for (int dy = -m; dy <= m; dy++) {
                        if (dx == 0 && dy == 0) {
                            continue;
                        }
                        int x = i;
                        int y = j;
                        StringBuilder sb = new StringBuilder();
                        while (0 <= x && x < n && 0 <= y && y < m) {
                            sb.append(graph[x][y]);
                            int num = Integer.parseInt(sb.toString());
                            if (ifSquare(num)) {
                                if (num > answer) answer = num;
                            }
                            x += dx;
                            y += dy;
                        }
                    }
                }
            }
        }
        System.out.println(answer);

    }

    public static boolean ifSquare(int n) {
        if (n < 0) return false;
        int x = (int) Math.sqrt(n);
        return x * x == n;
    }
}
