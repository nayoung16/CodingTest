import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] scores = new int[n];

        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }
        }
        // 랭킹이 꽉 찼거나 새 점수가 최하위 점수보다 작거나 같으면 진입 불가
        if (n == p && score <= scores[n-1]) {
            System.out.println(-1);
            return;
        }

        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (scores[i] > score) rank++;
            else break;
        }

        if (rank > p) System.out.println(-1);
        else System.out.println(rank);
    }
}