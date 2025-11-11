import java.io.*;
import java.util.*;

public class Main {
    static int n,l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        List<Long> answer = new ArrayList<>();
        long find_x = -1;
        int new_l = l;

        for (int k = l; k <= 100; k++) {
            int t = n - ((k-1)*k) / 2;
            if (t < 0) break;
            if (t % k != 0) continue;
            long x = t / k;
            if (x < 0) continue;
            new_l = k;
            find_x = x;
            break;
        }

        if ((new_l > 100) || (find_x == -1)) {
            System.out.println(-1);
            return;
        }

        for (long i = 0; i < new_l; i++) {
            answer.add(find_x+i);
        }
        for (Long a : answer) {
            System.out.print(a+" ");
        }

    }
}
