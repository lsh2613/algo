package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1916 {

    private static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        List[] list = new List[v + 1];
        for (int i = 0; i < v + 1; i++) {
            list[i] = new ArrayList<Node>();
        }

        StringTokenizer st;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[v + 1];
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        Queue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.idx]) {
                visited[now.idx] = true;
                for (int i = 0; i < list[now.idx].size(); i++) {
                    Node adj = (Node) list[now.idx].get(i);
                    if (!visited[adj.idx] && dist[now.idx] + adj.cost < dist[adj.idx]) {
                        dist[adj.idx] = dist[now.idx] + adj.cost;

                        pq.offer(new Node(adj.idx, dist[adj.idx]));
                    }
                }
            }
        }

        System.out.println(dist[end]);
    }

}
