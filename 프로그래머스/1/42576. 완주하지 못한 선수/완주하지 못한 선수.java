import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String person : participant) {
            map.put(person, map.getOrDefault(person,0)+1);
        }
        for (String c : completion) {
            int n = map.get(c) - 1;
            if (n > 0) map.put(c,n);
            else map.remove(c); 
        }
        return map.keySet().iterator().next();
    }
}