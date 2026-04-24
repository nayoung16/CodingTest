import java.util.*;

class Solution {
    
    class Node {
        String word;
        Integer count;
        
        Node(String word, Integer count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public boolean compareString(String word1, String word2) {
        int l = word1.length();
        int diff = 0;
        for (int i = 0; i < l; i++) {
            if (word1.charAt(i) != word2.charAt(i)) diff++;
        }
        if (diff == 1) return true;
        else return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (!Arrays.asList(words).contains(target)) return 0;
        
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin,0));
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            String curWord = curNode.word;
            if (curWord.equals(target)) return curNode.count;
            
            for (String word: words) {
                if (!visited.contains(word) && compareString(word, curWord)) {
                    visited.add(word);
                    queue.add(new Node(word, curNode.count + 1));
                }
            }
        }
        
        return 0;
    }
}