import java.io.*;
import java.util.*;

public class Main {

    static int n,m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] graphA = new int[n][m];
        int[][] graphB = new int[n][m];

        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < m; j++) {
                graphA[i][j] = Integer.parseInt(String.valueOf(string.charAt(j)));
            }
        }

        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < m; j++) {
                graphB[i][j] = Integer.parseInt(String.valueOf(string.charAt(j)));
            }
        }

        int count = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                if (graphA[i][j] != graphB[i][j]) {
                    count++;
                    flip(graphA,i,j);
                    if (compare(graphA, graphB)) {
                        System.out.println(count);
                        return;
                    }
                }
            }
        }
        if (compare(graphA, graphB)) {
            System.out.println(count);
        }
        else {
            System.out.println(-1);
        }

    }

    public static void flip(int[][] graph, int si, int sj) {
        for (int i = si; i < si+3 ; i++) {
            for (int j = sj; j < sj+3; j++) {
                graph[i][j] = 1- graph[i][j];
            }
        }
    }

    public static boolean compare(int[][] graphA, int[][] graphB) {
        boolean result = true;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if (graphA[i][j] != graphB[i][j]) result = false;
            }
        }
        return result;
    }
}