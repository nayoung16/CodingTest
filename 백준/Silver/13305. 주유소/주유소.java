import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] roads = new long[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            roads[i] = Long.parseLong(st.nextToken());
        }

        long[] gas = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            gas[i] = Long.parseLong(st.nextToken());
        }

        long minPrice = gas[0];
        long result = 0L;
        for (int i = 0; i < n-1; i++) {
            minPrice = Math.min(minPrice, gas[i]);
            result += minPrice * roads[i];
        }
        System.out.println(result);
    }
}