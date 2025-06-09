package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    static final int WALL = 0;
    static int[] end;
    static final int dx[] = {0, 1, 0, -1};
    static final int dy[] = {-1, 0, 1, 0};
    static boolean[][] visited;

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        end = new int[]{maps.length - 1, maps[0].length - 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            visited[now[0]][now[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length
                        || visited[nx][ny]
                        || maps[nx][ny] == WALL)
                    continue;

                int cnt = now[2] + 1;
                if (nx == end[0] && ny == end[1])
                    return cnt + 1;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, cnt});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int solution = new 게임맵최단거리().solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        });

        System.out.println("solution = " + solution);
    }
}
