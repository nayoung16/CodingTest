import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int ans = 64;
        for (int i=0; i<=n-8; i++) {
            for (int j=0; j<=m-8; j++) {
                ans = Math.min(ans,repaintCount(i,j));
            }
        }
        System.out.println(ans);
    }

    static int repaintCount(int sr, int sc) {
        int cntB = 0, cntW = 0;
        for (int r = sr; r<sr+8; r++) {
            for (int c = sc; c<sc+8; c++) {
                char expectedB = ((r + c) % 2 == 0) ? 'B' : 'W';
                char expectedW = ((r + c) % 2 == 0) ? 'W' : 'B';
                if (map[r][c] != expectedB) cntB++;
                if (map[r][c] != expectedW) cntW++;
            }
        }
        return Math.min(cntB, cntW);
    }
}
