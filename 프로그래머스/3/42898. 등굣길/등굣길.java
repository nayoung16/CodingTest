class Solution {
    private static final int MOD = 1_000_000_007;
    private static int[][] dp;
    private boolean[][] blocked;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new int[n][m];
        blocked = new boolean[n][m];
        
        for (int[] p : puddles) {
            int x = p[0] - 1; 
            int y = p[1] - 1;
            if (0 <= y && y < n && 0 <= x && x < m) blocked[y][x] = true;
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                calculateDp(puddles, n, m, i, j);
            }
        }
        return dp[n-1][m-1];
    }
    
    public void calculateDp(int[][] puddles, int n, int m, int i, int j) {
        if (i == 0 && j == 0) {
            dp[i][j] = 1;
            return;
        }
        if (blocked[i][j]) {
            dp[i][j] = 0;               
            return;
        }
        long fromUp = (i > 0) ? dp[i - 1][j] : 0;
        long fromLeft = (j > 0) ? dp[i][j - 1] : 0;
        dp[i][j] = (int)((fromUp + fromLeft) % MOD);
    }
}