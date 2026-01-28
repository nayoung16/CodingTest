import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int bar_num = 0; // 현재 막대기 개수
        int answer = 0; // 잘려진 막대기 총 개수
        for (int i=0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                bar_num++;
            }
            else {
                bar_num--;
                if (str.charAt(i - 1) == '(') {
                    // 레이저 "()" -> 현재 열려있는 막대 bar_num개를 자름
                    answer += bar_num;
                } else {
                    // 막대기 끝
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}