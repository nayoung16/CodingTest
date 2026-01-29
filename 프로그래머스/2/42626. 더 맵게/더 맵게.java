import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int sc : scoville) {
            pQ.add(sc);
        }
        while (true) {
            if (pQ.peek() >= K) break;
            if (pQ.size() < 2) {
                answer = -1;
                break;
            }
            answer++;
            int s1 = pQ.poll();
            int s2 = pQ.poll();
            int newS = s1 + s2 * 2;
            pQ.add(newS);
            

        }
        return answer;
    }
}