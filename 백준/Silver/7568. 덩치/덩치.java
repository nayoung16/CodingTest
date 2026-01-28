import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[n];
        int[][] weight = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            weight[i][0] = x;
            weight[i][1] = y;
        }

        // O(n^2)
        for (int i = 0; i < n; i++) {
            int cur_x = weight[i][0];
            int cur_y = weight[i][1];
            int cur_rank = 1;

            for (int j = 0; j < n; j++) {
                if ((weight[j][0] > cur_x) && (weight[j][1] > cur_y)) cur_rank++;
            }
            answer[i] = cur_rank;
        }

        for (int i = 0; i < n ; i++) {
            System.out.print(answer[i] + " ");
        }

    }
}