package ps.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10844 {

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 9;
        dp[2] = 17;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] * 2 - 1;
        }

        System.out.println(dp[n]);
    }

}
