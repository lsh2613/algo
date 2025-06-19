package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class B14502 {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] tmp;
    private static List<int[]> viruses = new ArrayList<>();
    private static int maxSafeSection = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2)
                    viruses.add(new int[]{i, j});
            }
        }

        dfs(0);

        System.out.println(maxSafeSection);
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    private static void dfs(int cnt) {
        if (cnt == 3) { // 벽이 3개라면
            // 바이러스 전파
            for (int i = 0; i < N; i++) {
                tmp[i] = Arrays.copyOf(map[i], map[i].length); // 깊은 복사
            }
            Queue<int[]> q = new LinkedList<>(viruses);
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                        continue;
                    if (tmp[nx][ny] == 0) {
                        tmp[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }

            // 안전 영역 계산
            long safeSection = Arrays.stream(tmp)
                    .flatMapToInt(IntStream::of)
                    .filter(i -> i == 0)
                    .count();

            // 안전 영역 최댓값 비교
            maxSafeSection = Math.max(maxSafeSection, (int) safeSection);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
}
