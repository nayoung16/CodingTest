class Solution {
    
    private int toSecond(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }
    
    private double[] getAngles(int t) {
        // 1초당 6도 이동, 1초당 0.1도, 1초당 1/120도
        double s_angle = (t * 6) % 360;
        double m_angle = (t / 10.0) % 360;
        double h_angle = (t / 120.0) % 360;
        
        return new double[]{h_angle, m_angle, s_angle};
    }
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int time1 = toSecond(h1,m1,s1);
        int time2 = toSecond(h2,m2,s2);
        
        double[] start = getAngles(time1);
        if (start[2] == start[0] || start[2] == start[1]) answer++;
        
        for (int t = time1; t < time2; t++) {
            double[] cur = getAngles(t);
            double hour1 = cur[0];
            double min1 = cur[1];
            double sec1 = cur[2];
            
            double[] next = getAngles(t+1);
            double hour2 = next[0];
            double min2 = next[1];
            double sec2 = next[2];
            if (hour2 < hour1) hour2 += 360;
            if (min2 < min1) min2 += 360;
            if (sec2 < sec1) sec2 += 360;
            
            boolean hitMin = (sec1 < min1 && min2 <= sec2);
            boolean hitHour = (sec1 < hour1 && hour2 <= sec2);
            
            if (hitMin) answer++;
            if (hitHour) answer++;
            if (hitMin && hitHour && (min2 == hour2)) {
                answer--;
            }
        }
        return answer;
    }
}