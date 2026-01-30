import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static final long MOD = 1_000_000_009L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // 1) 입력을 저장하면서 최댓값(maxN)도 같이 구한다.
        List<Integer> queries = new ArrayList<>(t);
        int maxN = 0;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            queries.add(n);
            if (n > maxN) maxN = n;
        }

        // 2) dp[x] = x를 1,2,3으로 '순서 무시'하고 만드는 경우의 수
        int[] dp = new int[maxN + 1];
        dp[0] = 1;

        int[] coins = {1, 2, 3};
        for (int sum = 1; sum <= maxN; sum++) {
            for (int coin : coins) {
                if (sum - coin >= 0)
                    dp[sum] = (int) ((dp[sum] + dp[sum - coin]) % MOD);
            }
        }

        // 3) 각 테스트케이스 답 출력
        StringBuilder sb = new StringBuilder();
        for (int n : queries) {
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }
}