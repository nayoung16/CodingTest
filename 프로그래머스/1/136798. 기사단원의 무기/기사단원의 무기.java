class Solution {
    
    public int calculate(int n) {
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) count += 1; // 제곱수
                else count += 2; // 쌍으로 존재
            }
        }
        return count;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i < number + 1; i++) {
            int factor = calculate(i);
            if (factor > limit) factor = power;
            answer += factor;
        }
        
        return answer;
    }
}