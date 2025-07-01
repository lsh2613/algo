package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            Integer last = lis.get(lis.size() - 1);
            if (last < nums[i]) {
                lis.add(nums[i]);
            } else {
                int left = 0;
                int right = lis.size();

                while (left < right) {
                    int mid = (left + right) / 2;
                    int key = nums[i];
                    if (lis.get(mid) < key) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                lis.set(left, nums[i]);
//                int idx = Collections.binarySearch(lis, nums[i]);
//                if (idx < 0) idx = -idx - 1;
//                lis.set(idx, nums[i]);
            }
        }
        System.out.println(lis.size());
    }
}
