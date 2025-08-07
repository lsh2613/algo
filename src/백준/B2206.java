package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206 {
    private static class Point {
        public int x, y, dist;
        public boolean canBreak;

        public Point(int x, int y, int dist, boolean canBreak) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.canBreak = canBreak;
        }

    }

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {-1, 0, 1, 0}; // 상우하좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[2][N][M];
        final int NOT_BROKEN = 0;
        final int BROKEN = 1;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Point> q = new LinkedList();
        q.add(new Point(0, 0, 1, true));

        while (!q.isEmpty()) {
            Point now = q.poll();

            /**
             * 도착 지점은 nx, ny로 비교하면 다음 Input에서 -1을 반환해주기 떄문에 now에서 검증
             * [Input]
             * 1 1
             * 0
             * ans = 1
             */
            if (now.x == N - 1 && now.y == M - 1) {
                System.out.println(now.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if (map[nx][ny] == 1 && now.canBreak) { // 벽이고, 부술 수 있고, 방문하지 않았다면
                    visited[BROKEN][nx][ny] = true;
                    q.offer(new Point(nx, ny, now.dist + 1, false));
                } else if (map[nx][ny] == 0) {
                    if (now.canBreak && !visited[NOT_BROKEN][nx][ny]) {
                        visited[NOT_BROKEN][nx][ny] = true;
                        q.offer(new Point(nx, ny, now.dist + 1, now.canBreak));
                    } else if (!now.canBreak && !visited[BROKEN][nx][ny]) {
                        visited[BROKEN][nx][ny] = true;
                        q.offer(new Point(nx, ny, now.dist + 1, now.canBreak));
                    }
                }
            }
        }

        System.out.println(-1);
    }
}


