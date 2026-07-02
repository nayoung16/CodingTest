class Solution {
    
    boolean[][][] visited;
    int answer;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int curY;
    int curX;

    public int getIndex(char dir) {
        if (dir == 'U') return 0;
        else if (dir == 'D') return 1;
        else if (dir == 'L') return 2;
        else if (dir == 'R') return 3;
        return -1;
    }

    public int getReverseDir(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        if (dir == 3) return 2;
        return -1;
    }

    public int solution(String dirs) {
        answer = 0;
        visited = new boolean[11][11][4];
        curY = 5;
        curX = 5;
        for (int i = 0; i < dirs.length(); i++) {
            int dir = getIndex(dirs.charAt(i));
            int nextY = curY + dy[dir];
            int nextX = curX + dx[dir];
            if (nextY < 0 || nextY > 10 || nextX < 0 || nextX > 10) {
                continue;
            }
            if (!visited[curY][curX][dir]) {
                answer++;
            }

            visited[curY][curX][dir] = true;
            visited[nextY][nextX][getReverseDir(dir)] = true;
            curY = nextY;
            curX = nextX;
        }
        return answer;

    }
}