import java.util.*;
class Solution {
    static class Num implements Comparable<Num>{
        String number;
        
        Num (String number) {
            this.number = number;
        }
        
        @Override
        public int compareTo(Num n) {
            return (n.number + this.number).compareTo(this.number + n.number);
        }
        
    }
    public String solution(int[] numbers) {
        boolean allZero = true;
        Num[] num = new Num[numbers.length];
        
        for(int i = 0; i < num.length; i++){
            num[i] = new Num(String.valueOf(numbers[i]));        
            if(numbers[i] != 0) allZero = false;
        }
        
        Arrays.sort(num);
        if (allZero) return "0";

        StringBuilder sb = new StringBuilder();
        for (Num x : num) {
            sb.append(x.number);
        }
        return sb.toString();
    }
}