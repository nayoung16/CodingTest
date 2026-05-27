import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col-1] == o2[col-1]) return o2[0] - o1[0];
            else return o1[col-1] - o2[col-1];
        }
        );

        for (int i = row_begin; i <= row_end; i++) {
            int si = 0;
            for (int d : data[i - 1]) { // i번째 행이므로 인덱스는 i-1
                si += d % i;
            }
            answer ^= si;

        }
        return answer;
    }
}