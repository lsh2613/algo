package 프로그래머스;

import java.util.PriorityQueue;
import java.util.Queue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int time = 0;
        Queue<Integer> pq = new PriorityQueue<>();

        for (int value : scoville) {
            pq.offer(value);
        }

        while (!pq.isEmpty()) {
            // pq의 최솟값이 k이상이라면 반환 후 종료
            if (pq.peek() >= K)
                return time;

            // 두 개를 꺼낼 수 없다면 스코빌 지수 만족 못하는 경우
            if (pq.size() < 2) return -1;

            // 스코빌 섞기
            time++;
            Integer pick1 = pq.poll();
            Integer pick2 = pq.poll();
            pq.offer(pick1 + pick2 * 2);
        }

        return -1;
    }
}
