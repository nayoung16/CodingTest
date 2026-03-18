import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Pillar {
        int x,h;

        Pillar(int x, int h) {
            this.x = x;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Pillar[] arr = new Pillar[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[i] = new Pillar(l,h);
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.x));

        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i].h > arr[maxIdx].h) {
                maxIdx = i;
            }
        }

        int area = 0;

        // 왼쪽 -> 가장 높은 기둥
        int leftIdx = 0;
        for (int i = 1; i <= maxIdx; i++) {
            if (arr[i].h >= arr[leftIdx].h) {
                area += arr[leftIdx].h * (arr[i].x - arr[leftIdx].x);
                leftIdx = i;
            }
        }

        // 오른쪽 -> 가장 높은 기둥
        int rightIdx = n - 1;
        for (int i = n - 2; i >= maxIdx; i--) {
            if (arr[i].h >= arr[rightIdx].h) {
                area += arr[rightIdx].h * (arr[rightIdx].x - arr[i].x);
                rightIdx = i;
            }
        }

        // 가장 높은 기둥 넓이
        area += arr[maxIdx].h;

        System.out.println(area);
    }
}