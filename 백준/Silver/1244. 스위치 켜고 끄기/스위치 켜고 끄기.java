import java.io.*;
import java.util.*;

public class Main {

    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] switches = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int a = Integer.parseInt(st.nextToken());
            switches[i] = a;
        }

        int m = Integer.parseInt(br.readLine());


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) { // 남
                for (int j = 0; j < n ; j++) {
                    if ((j+1) % num == 0) {
                        switches[j] = 1 - switches[j];
                    }
                }
            }
            else if (gender == 2) { // 여
                int s = num - 1;
                int t = 2 * s;
                switches[s] = 1 - switches[s];
                for (int j = num-1; j < n; j++) {
                    if (t - j >= 0) {
                        if (switches[j] == switches[t - j]) {
                            switches[j] = 1 - switches[j];
                            switches[t-j] = 1 - switches[t-j];
                        }
                        else break;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(switches[i]);
            if ((i+1) % 20 == 0) sb.append('\n');
            else if (i != n - 1) sb.append(' ');
        }
        System.out.println(sb);
    }
}