package 프로그래머스;

import java.util.HashSet;
import java.util.Set;

public class 네트워크_2 {
    static int[] parents;

    public int solution(int n, int[][] computers) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

//        Set<Integer> set = Arrays.stream(parents).boxed().collect(Collectors.toSet());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parents.length; i++) {
            set.add(find(parents[i]));
        }
        return set.size();
    }

    static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parents[parentX] != parents[parentY])
            parents[parentX] = parentY;
    }

    static int find(int n) {
        if (parents[n] != n) {
            parents[n] = find(parents[n]);
        }

        return parents[n];
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        int result = new 네트워크_2().solution(n, computers);
        System.out.println("result = " + result);
    }
}