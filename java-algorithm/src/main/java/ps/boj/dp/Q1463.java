package ps.boj.dp;

import java.io.*;

public class Q1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        bw.write(Integer.toString(dp[n]));
        bw.flush();
        bw.close();
    }

}
