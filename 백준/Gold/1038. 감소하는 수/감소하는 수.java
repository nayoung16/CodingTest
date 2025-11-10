import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        if (n > 1022) { System.out.println(-1); return; }

        ArrayList<Long> list = new ArrayList<>(1100);

        for (long i = 0; i<=9; i++) {
            list.add(i);
        }

        int idx = 0;
        while (idx < list.size()) {
            long x = list.get(idx++);
            long last = x % 10;
            for (int j=0; j<last; j++) {
                list.add(x*10+j);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(n));
    }
}
