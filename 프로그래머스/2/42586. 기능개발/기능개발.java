import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            q.offer(day);
        }
        
        while(!q.isEmpty()) {
            int deployDay = q.poll();
            int count = 1;
            
            while (!q.isEmpty() && q.peek() <= deployDay) {
                q.poll();
                count++;
            }
            answer.add(count);
        }
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}