package boj;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Q1065_한수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.println(countHansu(input));
    }

    private static int countHansu(int input) {
        if(input < 100) {
            return input;
        }
        AtomicInteger result = new AtomicInteger(99);
        IntStream.range(100, input + 1)
                .forEach(i -> {
                    if(verify(String.valueOf(i))) {
                        result.getAndIncrement();
                    }
                });
        return result.get();
    }

    private static boolean verify(String target) {
        int gap = target.charAt(0) - target.charAt(1);
        for(int i = 1; i < target.length() - 1; i++) {
            if(target.charAt(i) - target.charAt(i + 1) != gap) {
                return false;
            }
        }
        return true;
    }

}
