class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pvalue = Long.parseLong(p);
        for (int i=0; i <= t.length() - p.length(); i++) {
            long tvalue = Long.parseLong(t.substring(i,i+p.length()));
            if (tvalue <= pvalue) answer++;
        }
        return answer;
    }
}