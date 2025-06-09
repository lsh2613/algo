package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    public boolean[] visited;
    public static int cnt = 0;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            bfs(computers, i);
        }

        return cnt;
    }

    private void bfs(int[][] computers, int start) {
        if (visited[start]) {
            return;
        }
        cnt++;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int idx = q.poll();
            visited[idx] = true;
            for (int adjacent = 0; adjacent < computers[idx].length; adjacent++) {
                if (computers[idx][adjacent] == 1 && visited[adjacent]==false) {
                    q.offer(adjacent);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };
        int result = new 네트워크().solution(n, computers);
        System.out.println("result = " + result);
    }
}