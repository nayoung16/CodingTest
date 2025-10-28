import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> answer = new ArrayList<>();
        while (n != 0) {
            Long left = n % 10;
            answer.add(left.intValue());
            n /= 10;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}