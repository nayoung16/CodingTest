import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bfs(a,b);
        }

    }

    public static void bfs(int a, int b) {
        boolean[] visited = new boolean[10000];
        String[] cmd = new String[10000];
        Queue<Integer> q = new LinkedList<>();

        q.add(a);
        visited[a] = true;
        cmd[a] = "";
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == b) {
                System.out.println(cmd[cur]);
                return;
            }
            int d = calculateD(cur);
            if (!visited[d]) {
                visited[d] = true;
                cmd[d] = cmd[cur] + "D";
                q.add(d);
            }

            int s = calculateS(cur);
            if (!visited[s]) {
                visited[s] = true;
                cmd[s] = cmd[cur] + "S";
                q.add(s);
            }

            int l = calculateL(cur);
            if (!visited[l]) {
                visited[l] = true;
                cmd[l] = cmd[cur] + "L";
                q.add(l);
            }

            int r = calculateR(cur);
            if (!visited[r]) {
                visited[r] = true;
                cmd[r] = cmd[cur] + "R";
                q.add(r);
            }
        }
    }

    public static int calculateD(int num) {
        int result = num * 2;
        if (result > 9999) { return result % 10000; }
        return result;
    }

    public static int calculateS(int num) {
        if (num == 0) { return 9999; }
        return num - 1;
    }

    public static int calculateL(int num) {
        return (num % 1000) * 10 + (num / 1000);
    }

    public static int calculateR(int num) {
        return (num / 10) + (num % 10) * 1000;
    }

}