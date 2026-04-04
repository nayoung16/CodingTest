/*
컨테이너 벨트 : 한 방향 진행, 벨트에 놓인 순서대로 내릴 수 있음
보조 컨테이너 벨트 : 양방향 이동, 스택
*/
import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        Stack<Integer> stack = new Stack<>();
        int last = 0;
        int j = 0; // 택배 순서 인덱스
        for (int i = 1; i < n+1; i++) {
            if (i == order[j]) {
                //현재 택배 인덱스와 같다면
                answer++;
                j++;
            }
            else {
                stack.push(i);
            }
            while(!stack.isEmpty() && j < n && stack.peek() == order[j]) {
                stack.pop();
                answer++;
                j++;
            }
        }
        return answer;
    }
}