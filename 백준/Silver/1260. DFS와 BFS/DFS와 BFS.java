import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;
    static List<Integer>[] graph;
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;
    static List<Integer> dfs_result;
    static List<Integer> bfs_result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        M = Integer.parseInt(tokens[1]);
        V = Integer.parseInt(tokens[2]);
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] tokens1 = br.readLine().split(" ");
            int a = Integer.parseInt(tokens1[0]);
            int b = Integer.parseInt(tokens1[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited_dfs = new boolean[N + 1];
        visited_bfs = new boolean[N + 1];

        dfs_result = new ArrayList<>();
        bfs_result = new ArrayList<>();

        dfs(V);
        bfs(V);

        StringBuilder sb = new StringBuilder();
        for (int x : dfs_result) {
            sb.append(x).append(" ");
        }
        sb.append("\n");
        for (int x : bfs_result) {
            sb.append(x).append(" ");
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int u) {
        visited_dfs[u] = true;
        dfs_result.add(u);
        for (int v : graph[u]) {
            if (!visited_dfs[v]) dfs(v);
        }
    }

    public static void bfs(int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited_bfs[u] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            bfs_result.add(v);
            for (int w : graph[v]) {
                if (!visited_bfs[w]) {
                    queue.add(w);
                    visited_bfs[w] = true;
                }
            }
        }
    }
}
