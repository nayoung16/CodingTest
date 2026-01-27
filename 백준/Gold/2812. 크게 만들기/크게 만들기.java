import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String numstring = br.readLine();

        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            Integer num = Integer.parseInt(String.valueOf(numstring.charAt(i)));
            while (k > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }

        while (k>0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer s : stack) {
            sb.append(s);
        }
        System.out.println(sb);

    }
}