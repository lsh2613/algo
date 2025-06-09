package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기 {

    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int[][] map = new int[101][101];
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for(int[] r: rectangle){
            r[0] *= 2;
            r[1] *= 2;
            r[2] *= 2;
            r[3] *= 2;

            for(int x = r[0]; x <= r[2]; x++){
                for(int y = r[1]; y <= r[3]; y++){
                    // 테두리는 1
                    if(x == r[0] || x == r[2] || y == r[1] || y == r[3]) {
                        if(map[x][y] == -1) continue;
                        map[x][y] = 1;
                    }
                    // 내부는 -1
                    else map[x][y] = -1;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];

        queue.add(new int[]{characterX, characterY, 0}); //좌표 이동거리
        visited[characterX][characterY] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            // 아이템 위치 검증
            if(now[0] == itemX && now[1] == itemY)
                return now[2] / 2;

            for(int dir = 0; dir < 4; dir++){
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];

                if(nx < 0 || ny < 0 || nx >= 101 || ny >= 101) continue;
                if(visited[nx][ny] || map[nx][ny] != 1) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, now[2] + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // [[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]	1	3	7	8
        int solution = new 아이템줍기().solution(
                new int[][]{{1, 1, 5, 7}},
                1,
                1,
                4,
                7
        );

        System.out.println("solution = " + solution);
    }
}
