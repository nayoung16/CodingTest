import java.util.*;

class Solution {

    public String solution(String X, String Y) {
        String answer = "";
        int[] cntX = new int[10];
        int[] cntY = new int[10];
        
        for (int i = 0; i < X.length(); i++) {
            cntX[X.charAt(i) - '0']++;
        }
        
        for (int j = 0; j < Y.length(); j++) {
            cntY[Y.charAt(j) - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 9; i >= 0; i--) {
            int cnt = Math.min(cntX[i], cntY[i]);
            while (cnt-- > 0) {
                sb.append(i);
            }
        }
        answer = sb.toString();
        if (answer.equals("")) return "-1";
        if (answer.charAt(0) == '0') return "0";
        
        return answer;
    }
}