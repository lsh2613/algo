package 프로그래머스;

import java.util.Arrays;

public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> {
            return a[1] - b[1];
        });

        int max = routes[0][1];
        answer ++;
        for(int[] route : routes){
            if(max < route[0]) {
                max = route[1];
                answer++;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int solution = new 단속카메라().solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}});
        System.out.println("solution = " + solution);
    }
}
