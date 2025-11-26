import java.io.*;
import java.util.*;

public class Main {

    static int l;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }

        list.sort((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int count = 0;
        int lastEnd = 0;

        for (int[] meeting : list) {
            int start = meeting[0];
            int end = meeting[1];

            if (start >= lastEnd) {
                count++;
                lastEnd = end;
            }
        }

        System.out.println(count);
    }
}