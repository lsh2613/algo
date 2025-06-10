package 프로그래머스;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {

    private static class Node {
        int idx;
        int depth;

        public Node(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }

    private static List<List<Integer>> graph = new LinkedList<>();
    private static boolean[] visited;
    private static int answer = 0;
    private static int maxDepth = 0;
    public int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int[] ints : edge) {
            graph.get(ints[0]).add(ints[1]);
            graph.get(ints[1]).add(ints[0]);
        }

        bfs(1);

        return answer;
    }

    private void bfs(int n) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.depth == maxDepth)
                answer++;

            if (now.depth > maxDepth) {
                maxDepth = now.depth;
                answer = 1;
            }

            for (Integer adj : graph.get(now.idx)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    q.offer(new Node(adj, now.depth + 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        가장먼노드 solution = new 가장먼노드();

        int n = 6;
        int[][] edges = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        };

        int answer = solution.solution(n, edges);

        System.out.println("Answer: " + answer);
    }
}
