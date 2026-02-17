import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.min;


public class Main {

    static int[] budgets;
    static int n;

    static int search(int mid) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += min(budgets[i], mid);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        budgets = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int budget = Integer.parseInt(st.nextToken());
            if (budget > max) max = budget;
            budgets[i] = budget;
        }

        int total = Integer.parseInt(br.readLine());

        if (Arrays.stream(budgets).sum() <= total) { // 모두 배정 가능한 경우
            System.out.println(max);
        }
        else {
            // 이분탐색으로 상한선 찾기
            int start = 0;
            int end = max;
            int result = 0;
            while (start <= end) {
                int mid = (start + end) / 2;
                int searchedSum = search(mid);
                if (searchedSum <= total) {
                    result = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            System.out.println(result);

        }
    }
}