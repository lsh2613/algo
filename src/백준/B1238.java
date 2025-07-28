package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1238 {
    static int u, w, v, dist[], r_dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Node>[] adj = new ArrayList[n + 1];
        List<Node>[] r_adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            r_adj[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        r_dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(r_dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(w, v));
            r_adj[w].add(new Node(u, v));
        }

        // i~x 구하기
        dijkstra(adj, dist, x);

        // x~i 구하기
        dijkstra(r_adj, r_dist, x);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i] + r_dist[i]);
        }

        System.out.println(max);

    }

    static void dijkstra(List<Node>[] arr, int[] dist, int start) {
        PriorityQueue<Node> q = new PriorityQueue<Node>((n1, n2) -> n1.cost - n2.cost);
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (Node next : arr[now.to]) {
                if (dist[next.to] > dist[now.to] + next.cost) {
                    dist[next.to] = dist[now.to] + next.cost;
                    q.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }

    private static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

}