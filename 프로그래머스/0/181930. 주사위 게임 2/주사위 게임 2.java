class Solution {
    public int solution(int a, int b, int c) {
        int abc = a+b+c;
        int abc2 = (int)(Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2));
        int abc3 = (int)(Math.pow(a,3) + Math.pow(b,3) + Math.pow(c,3));
        if ((a != b) && (b != c) && (a != c)) return abc;
        if ((a == b) && (b==c)) return abc * abc2 * abc3;
        return abc * abc2;
    }
}