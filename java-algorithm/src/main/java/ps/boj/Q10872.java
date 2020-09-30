package ps.boj;

import java.util.Scanner;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class Q10872 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input < 0 || input > 12) {
            return;
        }
        int factorial = getFactorial(input);
        System.out.println(factorial);
    }

    private static int getFactorial(int input) {
        if (input <= 1) {
            return 1;
        }
        return input * getFactorial(input - 1);
    }

    @Test
    void test() {
        IntStream.range(0, 13).forEach(i -> System.out.println(getFactorial(i)));
    }

}
