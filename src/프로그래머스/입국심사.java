package 프로그래머스;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left=0;
        long right = times[times.length - 1] * (long)n;
        Arrays.sort(times);
        while (left <= right) {
            long mid = (left + right) / 2;
            System.out.println("mid = " + mid);
            long cnt = 0;
            for (int t : times) {
                cnt += mid / t;
            }

            if (cnt<n)
                left = mid + 1;
            else{
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        long solution = new 입국심사().solution(6, new int[]{7, 10});
        System.out.println("solution = " + solution);
    }
}
