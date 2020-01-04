package boj.dp;

import java.io.*;

public class Q9095 {

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberOfInput = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 12; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for(int i = 0; i < numberOfInput; i++) {
            int input = Integer.parseInt(br.readLine());
            bw.write(dp[input] + "\n");
        }

        bw.flush();
        bw.close();
    }

}
