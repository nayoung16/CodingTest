import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            // i 를 만드는 경우의 수 테이블 dp
            int[] dp = new int[n+1];
            
            for (int k = 1; k < n+1; k++) {
                if (k == 1) {
                    dp[1] = 1;
                    continue;
                }
                else if (k == 2) {
                    dp[2] = 2;
                    continue;
                }
                else if (k == 3) {
                    dp[3] = 4;
                    continue;
                }
                dp[k] = dp[k-1] + dp[k-2] + dp[k-3];
            }
            System.out.println(dp[n]);
        }
    }
}