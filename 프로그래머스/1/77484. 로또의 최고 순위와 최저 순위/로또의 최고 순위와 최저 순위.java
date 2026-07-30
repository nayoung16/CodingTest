import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int matchCount = 0;
 
        // 당첨 번호를 Set으로 변환해 빠르게 비교
        Set<Integer> winSet = new HashSet<>();
        for (int num : win_nums) {
            winSet.add(num);
        }
 
        // 로또 번호 확인
        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            } else if (winSet.contains(num)) {
                matchCount++;
            }
        }
 
        // 순위 계산
        int maxRank = getRank(matchCount + zeroCount); 
        int minRank = getRank(matchCount); 
 
        return new int[]{maxRank, minRank};
    }
 
    // 맞춘 개수에 따른 순위 계산
    private int getRank(int count) {
        return count >= 2 ? 7 - count : 6;
    }
}