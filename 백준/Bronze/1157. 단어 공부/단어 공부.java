import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        word = word.toUpperCase();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }

        int max = 0;
        Character answer = null;
        boolean isDup = false;
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (max == count) {
                isDup = true;
            }
            if (max < count) {
                max = count;
                answer = c;
                isDup = false;
            }
        }
        if (isDup) {
            System.out.println("?");
        } else {
            System.out.println(answer);
        }
    }
}