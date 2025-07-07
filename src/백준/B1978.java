package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1978 {
    static int N, M, maxDepth;
    static int[][] map;
    static boolean[] alphabetVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);
        map = new int[N][M];
        alphabetVisited = new boolean[26];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 1);

        System.out.println(maxDepth);
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0}; // 상우하좌

    private static void dfs(int x, int y, int depth) {
        alphabetVisited[map[x][y]] = true;
        maxDepth = Math.max(maxDepth, depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || alphabetVisited[map[nx][ny]])
                continue;

            dfs(nx, ny, depth + 1);
            alphabetVisited[map[nx][ny]] = false;
        }

    }
}
