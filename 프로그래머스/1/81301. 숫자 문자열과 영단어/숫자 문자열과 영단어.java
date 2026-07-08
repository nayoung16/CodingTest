import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight" , "nine"};
        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(arr[i], String.valueOf(i));
        }
        
        if (s.charAt(0) == '0') {
            s = s.substring(1);
        }
        answer = Integer.parseInt(s);
        
        return answer;
    }
}