class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int start = 0;
        for (int[] attack : attacks) {
            int timeBetween = attack[0] - start - 1;
            answer += timeBetween * bandage[1];
            if (timeBetween >= bandage[0]) {
                answer += (timeBetween / bandage[0]) * bandage[2];
            }
            if (answer > health) answer = health;
            answer -= attack[1];
            
            if (answer <= 0) return -1;
            start = attack[0];
        }
        return answer;
    }
}