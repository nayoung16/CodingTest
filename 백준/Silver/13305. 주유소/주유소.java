import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] roads = new int[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }

        int[] gas = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            gas[i] = Integer.parseInt(st.nextToken());
        }

        int minPrice = gas[0];
        int result = 0;
        for (int i = 0; i < n-1; i++) {
            minPrice = min(minPrice, gas[i]);
            result += minPrice * roads[i];
        }
        System.out.println(result);
    }
}