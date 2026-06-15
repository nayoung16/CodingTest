import java.util.*;
class Solution {
    
    int n;
    List<Integer> sequence;
    
    public int calculate(int n) {
        if (n % 2 == 0) {
            return n / 2;
        }
        else {
            return n*3+1;
        }
    }
    
    public double getExtent(int[] range, List<Integer> sequence) {
        int a = range[0];
        int b = n + range[1];
        double area = 0;
        if (a > b) {
            return -1.0;
        }
        for (int k = a; k < b; k++) {
            int start = sequence.get(k);
            int end = sequence.get(k+1);
            area += (double) (start + end) / 2;
        }
        return area;
    }
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        sequence = new ArrayList<>();
        n = 0;
        sequence.add(k);
        while (true) {
            int newK = calculate(k);
            sequence.add(newK);
            n++;
            k = newK;
            if (newK == 1) break;
        }
        
        int i = 0;
        for (int[] range : ranges) {
            double extent = getExtent(range, sequence);
            answer[i] = extent;
            i++;
        }
        
        return answer;
    }
}