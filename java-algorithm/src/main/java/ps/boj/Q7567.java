package ps.boj;

import java.util.Scanner;

public class Q7567 {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        char[] bowls = scanner.nextLine().toCharArray();
        int height = 10;
        for(int i = 1, lenght = bowls.length; i < lenght; i++) {
            height += bowls[i] == bowls[i - 1] ? 5 : 10;
        }
        System.out.println(height);
    }

}
