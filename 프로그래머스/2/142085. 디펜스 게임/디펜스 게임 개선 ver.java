import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];         // 병력 소모
            pq.offer(enemy[i]);    // 현재 라운드 적 수 저장

            // 병력이 부족하면 무적권 사용
            if (n < 0) {
                if (k > 0 && !pq.isEmpty()) {
                    n += pq.poll(); // 가장 큰 라운드 무적 처리
                    k--;
                } else {
                    break; // 무적권도 없으면 게임 종료
                }
            }
            answer++;
        }
        return answer;
    }
}
