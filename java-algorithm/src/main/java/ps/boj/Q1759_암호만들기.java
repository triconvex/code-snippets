package ps.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1759_암호만들기 {

    private static int DIGIT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        DIGIT = Integer.parseInt(first[0]);
        String[] second = br.readLine().split(" ");

        Arrays.sort(second);
        backtrack(second, 0, "");
    }

    private static void backtrack(String[] letters, int index, String result) {
        if(result.length() == DIGIT) {
            if(isValid(result)) {
                System.out.println(result);
            }

            return;
        }

        if(index > letters.length - 1) {
            return;
        }

        backtrack(letters, index + 1, result + letters[index]);
        backtrack(letters, index + 1, result);
    }

    private static boolean isValid(String target) {
        int consonants = 0;
        int vowels = 0;

        for(char letter : target.toCharArray()) {
            if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }

        return consonants >= 2 && vowels >= 1;
    }

}
