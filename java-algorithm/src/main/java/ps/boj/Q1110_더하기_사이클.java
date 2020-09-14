package ps.boj;

import java.util.Scanner;

public class Q1110_더하기_사이클 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int variable = sc.nextInt();
        int origin = variable;
        int count = 0;

        while (true) {
            ++count;
            variable = proceed(variable);
            if (origin == variable) {
                System.out.println(count);
                return;
            }
        }
    }

    private static int proceed(int variable) {
        int left = variable % 10;
        int right = (left + variable / 10) % 10;
        return left * 10 + right;
    }

}
