package ps.boj.dp;

import java.util.Scanner;

public class Q11052 {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInput = scanner.nextInt();
        int[] dp = new int[numberOfInput + 1];
        int[] input = new int[numberOfInput + 1];

        for(int i = 1; i <= numberOfInput; i++) {
            input[i] = scanner.nextInt();
        }

        for(int i = 1; i <= numberOfInput; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + input[j]);
            }
        }

        System.out.println(dp[numberOfInput]);
    }

}
