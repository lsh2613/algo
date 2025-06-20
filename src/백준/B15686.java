package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B15686 {

    static int N, M;
    static int[][] map;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static boolean[] open;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1)
                    houses.add(new int[]{i, j});
                if (map[i][j] == 2)
                    chickens.add(new int[]{i, j});
            }
        }

        open = new boolean[chickens.size()];

        dfs(0, 0);

        System.out.println(minDist);
    }

    private static void dfs(int start, int cnt) {
        if (cnt == M) { // 치킨집이 M개 열렸다면
            // 각 집마다 열려있는 치킨집의 최소 거리의 합
            int totalDist = 0;
            for (int[] house : houses) {
                int minDistPerHouse = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (open[i]) {
                        int[] chicken = chickens.get(i);
                        int dist = Math.abs(chicken[0] - house[0]) + Math.abs(chicken[1] - house[1]);
                        minDistPerHouse = Math.min(minDistPerHouse, dist);
                    }
                }
                totalDist += minDistPerHouse;
            }

            minDist = Math.min(minDist, totalDist);
            return;
        }

        for (int i = start; i < open.length; i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }
}
