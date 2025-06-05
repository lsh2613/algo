package 프로그래머스;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int cnt = 0;
        int start = 0;
        int end = people.length - 1;

        while (start <= end) {
            int sum = people[start] + people[end];

            if (sum > limit)
                end--;
            else {
                start++;
                end--;
            }

            cnt++;
        }

        return cnt;
    }
}
