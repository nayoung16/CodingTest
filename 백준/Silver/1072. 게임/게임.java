import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = (int) ((long) y * 100 / x);

        if (z >= 99) {
            System.out.println(-1);
            return;
        }

        int right = 1000000000;
        int left = 1;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int temp = (int) (((long) (y + mid) * 100) / (x + mid));
            if (temp > z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);

    }

}