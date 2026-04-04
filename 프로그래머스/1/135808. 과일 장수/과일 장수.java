/*
1 ~ k점 사과
한 상자에 사과 m개씩 담아 포장
상자에 담긴 가장 낮은 점수가 해당
*/
import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        for (int s : score) {
            pq.add(s);
        }
        int n = score.length;
        while (n >= m) {
            int minScore = k+1;
            for (int i = 0; i < m; i++) {
                int cur = pq.poll();
                minScore = Math.min(minScore, cur);
                n--;
            }
            answer += minScore * m;
        }
        
        return answer;
    }
}