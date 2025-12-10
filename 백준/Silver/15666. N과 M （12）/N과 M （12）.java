import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] numbers;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers[i] = number;
        }

        Arrays.sort(numbers);
        selected = new int[m];

        dfs(0,0);
        System.out.println(sb.toString());

    }

    static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int last = -1;
        for (int i = start; i < n; i++) {
            if (numbers[i] == last) {
                continue;
            }
            selected[depth] = numbers[i];
            last = numbers[i];
            dfs(depth + 1, i);
        }


    }
}