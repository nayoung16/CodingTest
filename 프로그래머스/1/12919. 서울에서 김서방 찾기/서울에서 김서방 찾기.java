class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int index = 0;
        for (int i=0; i<seoul.length; i++) {
            if (seoul[i].equals("Kim")) index = i;
        }
        return "김서방은 " + Integer.toString(index) + "에 있다";
    }
}