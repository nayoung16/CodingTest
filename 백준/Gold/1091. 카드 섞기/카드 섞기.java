import java.io.*;
import java.util.*;

public class Main {

    static int[] current;
    static int[] plist;
    static int[] slist;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        current = new int[n];
        for (int i = 0; i < n; i++) {
            current[i] = i;
        }
        plist = new int[n]; // 각 카드가 어떤 플레이어한테 가야 하는지
        slist = new int[n]; // 카드 섞는 방법
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            plist[i] = a;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            slist[i] = a;
        }

        if (ifSame()) {
            System.out.println(0);
            return;
        }

        int[] start = Arrays.copyOf(current, n);
        int answer = 0;
        while (true) {
            answer++;
            mix();

            if (ifSame()) {
                System.out.println(answer);
                return;
            }

            if (Arrays.equals(current, start)) {
                System.out.println(-1);
                return;
            }
        }

    }

    private static void mix() {
        int[] newList = new int[n];
        for (int i = 0; i < n; i++) {
            newList[slist[i]] = current[i];
        }
        current = newList;
    }

    private static boolean ifSame() {
        for (int i = 0; i < n; i++) {
            int card = current[i];
            // position i goes to player (i % 3)
            if (plist[card] != (i % 3)) return false;
        }
        return true;
    }
}