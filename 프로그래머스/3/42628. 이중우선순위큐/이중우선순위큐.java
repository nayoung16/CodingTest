import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pqLowest = new PriorityQueue<>();
        PriorityQueue<Integer> pqHighest = new PriorityQueue<>(Collections.reverseOrder());
        for (String op : operations) {
            String o = op.substring(0,1);
            Integer num = 0;
            if (op.charAt(2) == '-') {
                num = Integer.parseInt(op.substring(3)) * -1;
            }
            else {
                num = Integer.parseInt(op.substring(2));
            }
            if (o.equals("I")) {
                pqLowest.add(num);
                pqHighest.add(num);
            } else if (o.equals("D")) {
                if (pqLowest.size() == 0 && pqHighest.size() == 0) continue;
                if (num == 1) {
                    // 최댓값 삭제
                    int max = pqHighest.poll();
                    pqLowest.remove(max);
                } else if (num == -1) {
                    // 최솟값 삭제
                    int min = pqLowest.poll();
                    pqHighest.remove(min);
                }
            } 
        }
        if (pqLowest.size() == 0 && pqHighest.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[0] = pqHighest.poll();
            answer[1] = pqLowest.poll();
        }
        return answer;
    }
}