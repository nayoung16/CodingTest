import java.util.*;

class Solution {
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
    int[] str;
    int n;
    
    boolean isPrime(int N){
        // 소수 조건 1) 1보다 큰 자연수
        if(N < 2)	return false;

        for(int i=2; i<N; i++){
            if(N % i == 0)
                return false;
        }

        return true;
    }
    
    public void dfs(int depth, int targetLength, String current) {
        if (depth == targetLength) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) set.add(num);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth+1, targetLength, current+str[i]);
                visited[i] = false;
            }
        }
    }
    public int solution(String numbers) {
        n = numbers.length();
        str = new int[n];
        for (int i = 0; i < n; i++) {
            int c = numbers.charAt(i) - '0';
            str[i] = c;
        }
        
        for (int i = 1; i <= n ; i++) {
            String current = "";
            visited = new boolean[n];
            dfs(0, i, "");
        }
        
        return set.size();
    }
}