package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int str1Length = str1.length();
        int str2Length = str2.length();
        int[][] dp = new int[str1Length + 1][str2Length + 1];
        for (int i = 1; i <= str1Length; i++) {
            for (int j = 1; j <= str2Length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int cnt = dp[str1Length][str2Length];
        System.out.println(cnt);
        if (cnt != 0) {
            Stack<Character> s = new Stack<>();
            int i = str1Length;
            int j = str2Length;
            while (true) {
                if (i == 0 || j == 0)
                    break;

                if (dp[i][j] == dp[i - 1][j]) {
                    i--;
                } else if (dp[i][j] == dp[i][j - 1]) {
                    j--;
                } else {
                    s.push(str1.charAt(i - 1));
                    i--;
                    j--;
                }
            }
            while (!s.isEmpty()) {
                System.out.print(s.pop());
            }
        }

    }
}
