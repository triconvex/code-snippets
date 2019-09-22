package boj;

import org.junit.Test;

import java.util.Scanner;

public class Q2661_좋은수열 {

    private static boolean finished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        backtrack(n, "1");
    }

    private static void backtrack(int length, String target) {
        if(finished) {
            return;
        }

        if(target.length() == length) {
            if(isGoodProgression(target)) {
                System.out.println(target);
            }

            finished = true;
            return;
        }

        for(int i = 1; i <= 3; i++) {
            if(isGoodProgression(target + i)) {
                backtrack(length, target + i);
            }
        }
    }

    private static boolean isGoodProgression(String target) {
        for(int i = 1, length = target.length(); i <= length / 2; i++) {
            for(int j = 0; j <= length - i - i; j++) {
                String prev = target.substring(length - i - i, length - i);
                String next = target.substring(length - i);

                if(prev.equals(next)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test() {
        backtrack(7, "1");
    }

}
