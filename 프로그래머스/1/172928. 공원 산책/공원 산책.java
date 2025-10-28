class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        char[][] grid = new char[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            grid[i] = park[i].toCharArray();
        }
        
        int[] startPoint = findStart(grid);
        int h = park.length;        
        int w = park[0].length();   
        int cur_y = startPoint[0];
        int cur_x = startPoint[1];

        for (String route: routes) {
            char op = route.charAt(0);
            int n = Integer.parseInt(route.substring(2));
            if (op == 'N') {
                if (((cur_y - n) >= 0) && ((cur_y - n) < h)) {
                    boolean flag = true;
                    for (int i=1; i<=n; i++) {
                        if (grid[cur_y-i][cur_x] == 'X') flag = false;
                    }
                    if (flag) cur_y -= n;
                }
            }
            else if (op == 'S') {
                if (((cur_y + n) >= 0) && ((cur_y + n) < h)) {
                    boolean flag = true;
                    for (int i=1; i<=n; i++) {
                        if (grid[cur_y+i][cur_x] == 'X') flag = false;
                    }
                    if (flag) cur_y += n;
                }
            }
            else if (op == 'W') {
                if (((cur_x - n) >= 0) && ((cur_x - n) < w)) {
                    boolean flag = true;
                    for (int i=1; i<=n; i++) {
                        if (grid[cur_y][cur_x-i] == 'X') flag = false;
                    }
                    if (flag) cur_x -= n;
                }
            }
            else if (op == 'E') {
                if (((cur_x + n) >= 0) && ((cur_x + n) < w)) {
                    boolean flag = true;
                    for (int i=1; i<=n; i++) {
                        if (grid[cur_y][cur_x+i] == 'X') flag = false;
                    }
                    if (flag) cur_x += n;
                }
            }
        }
        int[] result = {cur_y, cur_x};
        return result;
    }
    
    public int[] findStart(char[][] grid) {
        int[] result = {0,0};
        for (int i=0; i < grid.length; i++) {
            for (int j=0; j< grid[0].length; j++) {
                if (grid[i][j] == 'S') {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}