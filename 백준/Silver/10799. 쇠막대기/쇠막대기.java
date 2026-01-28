import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int bar_num = 0; // 현재 막대기 개수
        int answer = 0; // 잘려진 막대기 총 개수
        for (int i=0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                if (str.charAt(i+1) != ')') {
                    // 레이저 아님, 막대기
                    bar_num++;
                    continue;
                }
            }
            else if (c == ')') {
                char s = stack.peek();
                if (s == '(') {
                    // 레이저
                    answer += bar_num;
                    stack.pop();
                }
                else {
                    // 막대기 끝
                    answer++;
                    bar_num--;
                }
            }
            stack.push(c);
        }
        System.out.println(answer);
    }
}