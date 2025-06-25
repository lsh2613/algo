package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1753 {
    static int N, M;
    static List<int[]>[] graph;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }

        dijkstra(start);
        for (int i = 1; i < dis.length; i++) {
            System.out.println(dis[i] == Integer.MAX_VALUE ? "INF" : dis[i]);
        }
    }

    private static void dijkstra(int start) {
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});
        dis[start] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowIdx = now[0];

            for (int[] adj : graph[nowIdx]) {
                int adjIdx = adj[0];
                int adjCost = adj[1];
                if (dis[adjIdx] > adjCost + dis[nowIdx]) {
                    dis[adjIdx] = adjCost + dis[nowIdx];
                    pq.offer(new int[]{adjIdx, dis[adjIdx]});
                }
            }
        }
    }
}
