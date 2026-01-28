import java.io.*;
import java.util.*;

public class Main {
    static int kGold, kSilver, kBronze;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            // 금, 은, 동
            int nation = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(List.of(nation, gold, silver, bronze));
            if (nation == k) {
                kGold = gold;
                kSilver = silver;
                kBronze = bronze;
            }
        }

        int rank = 1;

        // k번째 국가보다 높은 등수인 국가 찾아서 등수 더하기
        for (List<Integer> cur : list) {
            int gold = cur.get(1);
            int silver = cur.get(2);
            int bronze = cur.get(3);

            // k보다 잘한 경우
            if (gold > kGold) rank++;
            else if (gold == kGold && silver > kSilver) rank++;
            else if (gold == kGold && silver == kSilver && bronze > kBronze) rank++;
        }

        System.out.println(rank);

    }
}