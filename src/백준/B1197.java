package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

//        int weight = prim(n, m, br);
        int weight = unionFind(n, m, br);

        System.out.println(weight);
    }

    private static int[] parent;

    private static int unionFind(int n, int m, BufferedReader br) throws IOException {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{u, w, v});
        }

        int weight = 0;
        int edges = 0;

        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int u = now[0];
            int w = now[1];
            int v = now[2];

            if (union(u, w)) {
                weight += v;
                edges++;
            }

            if (edges == m - 1)
                break;
        }

        return weight;
    }

    private static boolean union(int u, int w) {
        int parentU = find(u);
        int parentW = find(w);

        if (parentU == parentW)
            return false;

        parent[parentU] = parentW;
        return true;
    }

    private static int find(int n) {
        if (parent[n] != n)
            parent[n] = find(parent[n]);

        return parent[n];
    }

    private static int prim(int n, int m, BufferedReader br) throws IOException {
        StringTokenizer st;
        List<int[]>[] g = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            g[u].add(new int[]{w, v});
            g[w].add(new int[]{u, v});
        }

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{1, 0});

        int weight = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int idx = now[0];
            int v = now[1];

            if (visited[idx]) continue;

            visited[idx] = true;
            weight += v;

            for (int i = 0; i < g[idx].size(); i++) {
                int[] adj = g[idx].get(i);
                if (!visited[adj[0]]) {
                    pq.offer(new int[]{adj[0], adj[1]});
                }
            }
        }
        return weight;
    }
}
