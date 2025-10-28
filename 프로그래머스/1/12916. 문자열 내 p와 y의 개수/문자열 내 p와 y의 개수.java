class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int s_len = s.length();
        int count_p = 0;
        int count_y = 0;
        for (int i=0; i<s_len; i++) {
            char c = s.charAt(i);
            if ((c == 'Y') | (c == 'y')) count_y++;
            if ((c == 'P') | (c == 'p')) count_p++;
        }
        if (count_p == count_y) return true;
        else return false;

    }
}