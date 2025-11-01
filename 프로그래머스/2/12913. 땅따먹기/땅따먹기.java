class Solution {
    public int solution(int[][] land) {
        int answer = 0;

        int h = land.length;
        int w = land[0].length;
        
        int[][] board = new int[h][w];
        for (int i=0; i<w; i++) {
            board[0][i] = land[0][i];
        }
        
        for (int i=1; i<h; i++) {
            for (int j=0; j<w; j++) {
                int max = 0;
                for (int x=0; x<w; x++) {
                    if (x==j) continue;
                    max = Math.max(max, land[i-1][x]);
                }
                land[i][j] += max;
                if (i == h-1) {
                    if (land[i][j] > answer) answer = land[i][j];
                }
            }
        }
    
        return answer;
    }
    
}