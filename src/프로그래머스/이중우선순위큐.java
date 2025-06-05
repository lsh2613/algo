package 프로그래머스;

import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");
            String command = operation[0];
            int value = Integer.parseInt(operation[1]);

            if (command.equals("I")) { // 삽입
                pq.add(value);
            } else if (command.equals("D")) { // 삭제
                if (pq.isEmpty()) continue;

                if (value == 1) { // 최대값 제거
                    int max = pq.stream().max(Integer::compareTo).orElseThrow();
                    pq.remove(max);
                } else if (value == -1) { // 최소값 제거
                    // 최소값 제거
                    pq.poll();
                }
            }
        }

        if (pq.isEmpty()) {
            return new int[]{0, 0};
        } else {
            int max = pq.stream().max(Integer::compareTo).orElseThrow();
            int min = pq.stream().min(Integer::compareTo).orElseThrow();
            return new int[]{max, min};
        }
    }

    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(0);
        pq.add(0);

        pq.remove(0);

        System.out.println("pq.size() = " + pq.size());
        System.out.println("pq.poll() = " + pq.poll());
    }
}
