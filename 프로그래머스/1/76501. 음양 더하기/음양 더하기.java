class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int len = absolutes.length;
        for (int i=0; i<len; i++) {
            boolean sign = signs[i];
            if (sign) {
                answer += absolutes[i];
            }
            else {
                answer += absolutes[i] * -1;
            }
        }
        return answer;
    }
}