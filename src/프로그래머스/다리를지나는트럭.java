package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int currentWeight = 0;
        int time = 0;
        int idx = 0;

        Queue<int[]> bridge = new LinkedList<>(); // [트럭 무게, 다리를 건너는 데 소요되는 전체 시간]

        while (idx < truck_weights.length || !bridge.isEmpty()) {
            time++;

            // 트럭 제거
            if (!bridge.isEmpty() && bridge.peek()[1] == time) {
                currentWeight -= bridge.poll()[0];
            }

            // 트럭 추가
            if (idx < truck_weights.length) {
                if (truck_weights[idx] + currentWeight <= weight // 현재 다리 무게 + 다음 트럭 무게가 최대 무게보다 작거나 같고
                        && bridge.size() < bridge_length) { // 다리에 존재하는 트럭 갯수가 다리 길이보다 작은 경우
                    bridge.add(new int[]{truck_weights[idx], time + bridge_length});
                    currentWeight += truck_weights[idx];
                    idx++;
                }
            }
        }

        return time;
    }
}
