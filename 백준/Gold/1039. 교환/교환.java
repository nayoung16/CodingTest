import java.io.*;
import java.util.*;

public class Main {
    static int m,k;
    static String n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = st.nextToken();
        m = n.length();
        k = Integer.parseInt(st.nextToken());

        if (m == 1 || (m == 2 && n.charAt(1) == '0')) {
            System.out.println(-1);
            return;
        }

        Queue<String> q = new LinkedList<>();
        q.add(n);

        for (int t = 0; t < k; t++) {
            int size = q.size();
            if (size == 0) break;

            Set<String> set = new HashSet<>();

            while (size-- > 0) {
                String s = q.poll();
                char[] arr = s.toCharArray();

                for (int i=0; i<m; i++) {
                    for (int j=i+1; j<m; j++) {
                        char[] new_arr = Arrays.copyOf(arr, arr.length);
                        new_arr[i] = arr[j];
                        new_arr[j] = arr[i];

                        if (new_arr[0] != '0') {
                            String next = new String(new_arr);
                            if (!set.contains(next)) {
                                set.add(next);
                                q.add(next);
                            }
                        }
                    }
                }

            }
        }

        if (q.isEmpty()) {
            System.out.println(-1);
        } else {
            int answer = 0;
            while (!q.isEmpty()) {
                String s = q.poll();
                int val = Integer.parseInt(s);
                if (val > answer) answer = val;
            }
            System.out.println(answer);
        }

    }

}