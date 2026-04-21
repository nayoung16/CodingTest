import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.offer(price);
        }
        int[] answer = new int[prices.length];
        int idx = 0;
        while (!queue.isEmpty()) {
            int price = queue.poll();
            int sec = 0;
            for (Integer q : queue) {
                sec++;
                if (price > q) break;
            }
            answer[idx] = sec;
            idx++;
        }
        
        return answer;
    }
}