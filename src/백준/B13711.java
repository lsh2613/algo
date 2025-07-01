package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B13711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nToIdx = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nToIdx[num] = i;
        }

        st = new StringTokenizer(br.readLine());
        List<Integer> LIS = new ArrayList<>();
        int num = Integer.parseInt(st.nextToken());
        LIS.add(nToIdx[num]);

        for (int i = 1; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            int key = nToIdx[num];
            if (LIS.get(LIS.size() - 1) < key)
                LIS.add(key);
            else {
                int idx = Collections.binarySearch(LIS, key);
                idx = idx < 0 ? -idx - 1 : idx;
                LIS.set(idx, key);
            }
        }
        System.out.println(LIS.size());
    }
}
