import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Road {
        int end, dist;

        Road(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        List<Road>[] roads = new ArrayList[d+1];
        for (int i = 0; i <= d; i++) {
            roads[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (end > d) continue;
            if (end - start <= dist) continue;

            roads[start].add(new Road(end, dist));
        }

        // d 길이까지의 지름길 저장하는 dp 테이블
        int[] dp = new int[d+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < d; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            dp[i+1] = Math.min(dp[i+1], dp[i]+1);

            for (Road road : roads[i]) {
                // 각 시작점 지름길들
                int cur = dp[i] + road.dist;
                dp[road.end] = Math.min(dp[road.end], cur);
            }
        }

        System.out.println(dp[d]);
    }
}