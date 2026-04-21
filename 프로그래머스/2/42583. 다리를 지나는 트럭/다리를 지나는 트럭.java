import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) bridge.offer(0);
        int currentWeight = 0; // 현재 다리 위 무게
        Queue<Integer> truckWeights = new LinkedList<>();
        for (int tweight : truck_weights) {
            truckWeights.offer(tweight);
        }
        
        while (!bridge.isEmpty()) {
            answer++;
            int outTruck = bridge.poll();
            currentWeight -= outTruck;
            if (!truckWeights.isEmpty()) {
                if (currentWeight + truckWeights.peek() <= weight) {
                    int newTruck = truckWeights.poll();
                    bridge.offer(newTruck);
                    currentWeight += newTruck;
                }
                else bridge.add(0);
            }
        }
        return answer;
    }
}