        // t초동안 붕대감기, 1초마다 x만큼 체력 회복
        // t초 연속 붕대 감으면 y만큼 체력 추가 회복
        // 현재 체력은 최대 체력보다 커질 수 없음
        // 기술 쓰는 도중 몬스터에게 공격 -> 기술 취소
        // 공격 당하는 순간에는 체력 회복 x

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int playerHealth = health;
        int time = 0;
        for (int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0];
            int attackHealth = attacks[i][1];
            
            //공격받기 전까지 체력회복 계산
            if (attackTime - time > 1) {
                int curHealth = playerHealth + (attackTime - time - 1) * bandage[1];
                if (attackTime - time > bandage[0]) {
                    // 연속 성공
                    curHealth += ((attackTime - time - 1)/bandage[0])*bandage[2];
                }
                
                if (curHealth < health) playerHealth = curHealth;
                else playerHealth = health;
            }
            
            System.out.println(time + " " + playerHealth);
            //공격
            playerHealth -= attackHealth;
            time = attackTime;
            
            System.out.println(time + " " + playerHealth);

            if (playerHealth <= 0) {
                return -1;
            }
        }
        return playerHealth;
    }
}