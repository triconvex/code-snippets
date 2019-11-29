import java.util.Arrays;
import java.util.List;

public class SwitchTest {

    public static void main(String[] args) {
        List<String> letters = Arrays.asList("a", "b", "c", "d");

        for(String letter : letters) {
            switch(letter) {
                case "a":
                    System.out.println(letter);
                    break;
                case "b":
                    System.out.println(letter);
                    break;
                case "c":
                case "d":
                    break;
            }
        }

        List<String> letters2 = Arrays.asList("a", "b", "c", "d");

        for(String letter : letters2) {
            switch(letter) {
                case "a":
                    System.out.println(letter); // no break then ...
                case "b":
                    System.out.println(letter); // fall through to last case "d"
                case "c":
                case "d":
                    break;
                    /*
                    Should we use a break; in the last default case?
                        From The C programming language - Second edition (K&R 2): Chapter 3.4 Switch

                    As a matter of good form, put a break after the last case (the default here) even though it's logically unnecessary.
                    Some day when another case gets added at the end, this bit of defensive programming will save you.
                     */
            }
        }
    }

}
