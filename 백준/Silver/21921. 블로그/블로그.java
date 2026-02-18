import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] visitors = new int[n];

        for (int i = 0; i < n; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += visitors[i];
        }
        int max = sum;
        int count = 1;
        for (int i = x; i < n; i++) {
            sum += (visitors[i] - visitors[i-x]);
            if (sum > max) {
                max = sum;
                count = 1;
            }
            else if (sum == max) count++;
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}