class Solution {
    
    public boolean check(String babble) {
        String[] possible = {"aya", "ye", "woo", "ma"};
        String[] impossible = {"ayaaya", "yeye", "woowoo", "mama"};
        boolean isCheck = true;
        
        for (String im : impossible) {
            if (babble.contains(im)) {
                isCheck = false;
                break;
            }
        }
        
        for (String p : possible) {
            babble = babble.replace(p, " ");
        }
        
        if (babble.replace(" ","").length() != 0) {
            isCheck = false;
        }
        return isCheck;
    }
    
    public int solution(String[] babbling) {
        int answer = 0;
        for (String babble : babbling) {
            if(check(babble)) answer++;
        }
        return answer;
    }
}