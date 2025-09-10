import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        for (int i=0; i<enemy.length; i++) {
            if(n>=enemy[i]) {
                n -= enemy[i];
                que.offer(enemy[i]);
                answer++;
            } else {
                // 무적권이 남아 있다면
                if (k>0) {
                    // que에 숫자가 있는 경우, 가장 큰 숫자를 꺼내서 무적권 사용처리
                    if(!que.isEmpty()) {
                        if (que.peek() > enemy[i]) {
                            n += que.poll();
                            n -= enemy[i];
                            que.offer(enemy[i]);
                        }
                    }
                    // que에 숫자 없는 경우 무적권 사용처리
                    answer++;
                    k--;
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}