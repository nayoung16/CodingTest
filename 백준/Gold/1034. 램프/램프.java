import java.io.*;
import java.util.*;

public class Main {

    static int n,m,k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        k = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int zeroCount = 0;
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) zeroCount++;
            }
            if (zeroCount <= k && (k - zeroCount) % 2 == 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(graph[i][j]);
                }
                String pattern = sb.toString();
                map.put(pattern, map.getOrDefault(pattern, 0) + 1);
            }
        }
        int answer = 0;
        for (int cnt : map.values()) {
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);

    }
}