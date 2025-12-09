import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int count1 = 0;
        int count2 = 0;

        for (Character c : map1.keySet()) {
            if (map2.containsKey(c)) {
                int cur_count1 = map1.get(c);
                int cur_count2 = map2.get(c);
                if (cur_count1 > cur_count2) {
                    count1 += (cur_count1 - cur_count2);
                }
            }
            else {
                count1 += map1.get(c);
            }
        }

        for (Character c : map2.keySet()) {
            if (map1.containsKey(c)) {
                int cur_count1 = map1.get(c);
                int cur_count2 = map2.get(c);
                if (cur_count2 > cur_count1) {
                    count2 += (cur_count2 - cur_count1);
                }
            }
            else {
                count2 += map2.get(c);
            }
        }
        System.out.println(count1 + count2);
    }
}