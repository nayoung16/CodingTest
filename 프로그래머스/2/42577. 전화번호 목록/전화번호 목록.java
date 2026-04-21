import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        
        for (String phone : phone_book) {
            map.put(phone,0);
        }
        
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String str = phone.substring(0,i);
                if (map.containsKey(str)) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}