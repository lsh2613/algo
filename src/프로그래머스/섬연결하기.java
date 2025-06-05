package 프로그래머스;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {

    static int[] parents;

    public int solution(int n, int[][] costs) throws IOException {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

        int maxEdge = n - 1;
        int edge = 0;
        int totalCost = 0;

        for (int[] cost : costs) {
            int x = cost[0];
            int y = cost[1];
            int value = cost[2];

            if (union(x, y)) {
                edge++;
                totalCost += value;
            }

            if (edge == maxEdge) break;
        }

        return totalCost;
    }

    private boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) return false;

        parents[parentX] = parentY;
        return true;
    }

    private int find(int n) {
        if (parents[n] != n) parents[n] = find(parents[n]);
        return parents[n];
    }

    public static void main(String[] args) throws IOException {
        // [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]
        int solution = new 섬연결하기().solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});
        System.out.println(solution);
    }
}
