import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int l = citations.length; // 발표 논문 수
        Arrays.sort(citations);
        // 0 1 3 5 6
        for (int i = 0; i < l; i++) {
            // i : 인용 편 수
            int c = citations[i]; // 인용 횟수
            int papers = l - i; // c 이상 인용 된 논문 개수
            if (c >= papers) {
                return papers;
            }
        }
        return answer;
    }
}