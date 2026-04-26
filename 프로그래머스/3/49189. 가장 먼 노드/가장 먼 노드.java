import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n+1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] each : edge) {
            graph[each[0]].add(each[1]);
            graph[each[1]].add(each[0]);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        dist[1] = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (Integer nxt : graph[cur]) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    queue.offer(nxt);
                }
            }
        }
        
        int max = Arrays.stream(dist).max().getAsInt();
        int count = 0;
        for (int d : dist) {
            if (d == max) count++;
        }
        return count;
    }
}