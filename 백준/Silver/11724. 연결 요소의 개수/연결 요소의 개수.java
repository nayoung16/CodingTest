import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);

    }

    public static void dfs(int i) {
        visited[i] = true;
        for ( int v : graph[i] ) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

}