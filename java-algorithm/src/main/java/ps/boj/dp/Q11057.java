package ps.boj.dp;

import java.io.*;
import java.util.Arrays;

public class Q11057 {

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];

        for(int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i < n + 1; i++) {
            dp[i][0] = 1;
            for(int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
            }
        }

        bw.write(Integer.toString(dp[n][9]));
        bw.flush();
        bw.close();
    }

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[10];
        Arrays.fill(dp, 1);

        int sum = 1;
        for (int i = 1; i < n + 1; i++) {
            dp[1] = 1;
            for (int j = 2; j <= 9; j++) {
                dp[j] += dp[j - 1] % 10007;
            }
            sum += dp[9] % 10007;
        }

        System.out.println(sum);
    }

}
