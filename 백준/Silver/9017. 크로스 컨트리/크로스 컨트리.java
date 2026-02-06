import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int teamNum = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                teamNum = Math.max(teamNum, arr[j]);
            }

            int[] people = new int[teamNum+1];
            for (int x : arr) people[x]++;

            boolean[] valid = new boolean[teamNum+1];
            for (int team = 1; team <= teamNum; team++) {
                if (people[team] >= 6) {
                    valid[team] = true;
                }
            }

            int[] cnt = new int[teamNum + 1];
            int[] score = new int[teamNum + 1];
            int[] fifth = new int[teamNum + 1];
            Arrays.fill(score, 0);
            Arrays.fill(fifth, Integer.MAX_VALUE);

            int rank = 0;
            for (int x : arr) {
                if (!valid[x]) continue;
                rank++;
                cnt[x]++;

                if (cnt[x] <= 4) score[x] += rank;
                else if (cnt[x] == 5) fifth[x] = rank;
            }

            int winner = -1;
            int bestScore = Integer.MAX_VALUE;
            int bestFifth = Integer.MAX_VALUE;

            for (int team = 1; team <= teamNum; team++) {
                if (!valid[team]) continue;

                if (score[team] < bestScore) {
                    bestScore = score[team];
                    bestFifth = fifth[team];
                    winner = team;
                } else if (score[team] == bestScore) {
                    if (fifth[team] < bestFifth) {
                        bestFifth = fifth[team];
                        winner = team;
                    }
                }
            }

            sb.append(winner).append('\n');
        }
        System.out.println(sb.toString());
    }
}