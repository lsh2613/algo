package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int str1Length = str1.length();
        int str2Length = str2.length();
        int str3Length = str3.length();
        int[][][] dp = new int[str1Length + 1][str2Length + 1][str3Length + 1];

        for (int i = 1; i <= str1Length; i++) {
            for (int j = 1; j <= str2Length; j++) {
                for (int k = 1; k <= str3Length; k++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)
                            && str1.charAt(i - 1) == str3.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }

        System.out.println(dp[str1Length][str2Length][str3Length]);
    }
}
