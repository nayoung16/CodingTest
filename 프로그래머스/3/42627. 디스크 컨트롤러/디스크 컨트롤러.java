import java.util.*;

class Solution {
    
    class Job implements Comparable<Job> {
        int index;
        int startTime;
        int spendTime;
        
        Job(int index, int startTime, int spendTime) {
            this.index = index;
            this.startTime = startTime;
            this.spendTime = spendTime;
        }
        
        @Override
        public int compareTo(Job other) {
            return this.spendTime - other.spendTime;
        }
    }
    
    public int solution(int[][] jobs) {
        int totalJobs = jobs.length;
        List<Job> jobList = new ArrayList<>();
        
        for (int i = 0; i < jobs.length; i++) {
            jobList.add(new Job(i, jobs[i][0], jobs[i][1]));
        }
        
        // 요청 시간 기준 정렬
        jobList.sort((a, b) -> a.startTime - b.startTime);
        
        int time = 0;
        int count = 0;
        int totalTime = 0;
        int idx = 0;
        
        // 소요 시간 기준 우선순위 큐
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        while (count < totalJobs) {
            // 현재 시점까지 요청된 작업들을 모두 pq에 추가
            while (idx < totalJobs && jobList.get(idx).startTime <= time) {
                pq.add(jobList.get(idx));
                idx++;
            }
            
            if (!pq.isEmpty()) {
                Job current = pq.poll();
                time += current.spendTime;
                totalTime += time - current.startTime;
                count++;
            } else {
                time++;
            }
        }
        
        return totalTime / totalJobs;
    }
}