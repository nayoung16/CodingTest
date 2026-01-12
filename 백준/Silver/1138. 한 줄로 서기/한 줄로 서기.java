import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] people = new int[n+1];
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < n+1; i++) {
            int p = Integer.parseInt(st.nextToken());
            people[i] = p;
        }

        for (int i = n; i>=1; i--) {
            result.add(people[i],i);
        }

        StringBuilder sb = new StringBuilder();
        for (int su : result) {
            sb.append(su).append(" ");
        }

        System.out.println(sb);
    }

}