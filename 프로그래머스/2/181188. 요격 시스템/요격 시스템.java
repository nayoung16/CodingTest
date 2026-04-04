import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> {
            return a[1] - b[1]; // 끝나는 시간 기준
        });
        
        int count = 0;
        int last = -1;
        for (int[] t : targets) {
            if (last <= t[0]) {
                count++;
                last = t[1];
            }
        }
        return count;
    }
}