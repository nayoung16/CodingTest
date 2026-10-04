import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] notCleared = new int[N];
        int[] onStage = new int[N];
        for (int stage : stages) {
            for (int i = 1; i <= stage && i <= N; i++) {
                onStage[i-1]++;
            }
            if (stage <= N) {
                notCleared[stage-1]++;
            }
        }
        
        Integer[] stagesNum = new Integer[N];
        
        for (int i = 0; i < N; i++) {
            stagesNum[i] = i;
        }
        
        Arrays.sort(stagesNum, (a,b) -> {
            // 실패율 계산
            double failureA = (onStage[a] == 0) ? 0 : (double) notCleared[a] / onStage[a];
            double failureB = (onStage[b] == 0) ? 0 : (double) notCleared[b] / onStage[b];
            
            if (failureA == failureB) { // 번호 오름차순
                return a-b;
            }
            return Double.compare(failureB, failureA); // 실패율 정렬 내림차순
            
        });
        
        for (int i = 0; i < N; i++) {
            answer[i] = stagesNum[i] + 1;
        }
        
        return answer;
    }
}