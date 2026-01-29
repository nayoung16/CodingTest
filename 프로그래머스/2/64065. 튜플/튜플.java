import java.util.*;

class Solution {
    static class TupleSet implements Comparable<TupleSet> {
        Set<Integer> set;
        
        TupleSet(Set<Integer> set) {
            this.set = set;
        }
        
        @Override
        public int compareTo(TupleSet o) {
            return this.set.size() - o.set.size();
        }
    }
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] parts = s.split("\\},\\{");
        
        List<TupleSet> list = new ArrayList<>();
        for (String part : parts) {
            String[] nums = part.split(",");
            Set<Integer> set = new HashSet<>();
            for (String num : nums) {
                set.add(Integer.parseInt(num));
            }
            list.add(new TupleSet(set));
        }
        
        Collections.sort(list);
        
        List<Integer> result = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        
        for (TupleSet ts : list) {
            for (int x : ts.set) {
                if (!used.contains(x)) {
                    used.add(x);
                    result.add(x);
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}