import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] place = new int[m+2];
        place[0] = 0;
        place[m+1] = n;
        for (int i = 1; i < m+1; i++) {
            place[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int max = 0;
        for (int i = 1; i < m+2; i++) {
            int end = place[i];
            int h = 0;
            if (i == 1 || i == (m+1)) {
                h = end - start;
            }
            else {
                h = (int) Math.ceil((end - start + 1)/2);
            }
            if (h > max) max = h;
            start = end;
        }

        System.out.println(max);
    }
}