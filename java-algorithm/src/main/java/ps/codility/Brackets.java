package ps.codility;

import java.util.EmptyStackException;
import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Brackets {

    public int solution(String S) {
        Stack<Character> letters = new Stack<>();
        try {
            for (char c : S.toCharArray()) {
                if (c == '}' && letters.peek() == '{'
                    || (c == ')' && letters.peek() == '(')
                    || (c == ']' && letters.peek() == '[')) {
                    letters.pop();
                } else {
                    letters.push(c);
                }
            }
        } catch (EmptyStackException e) {
            return 0;
        }
        return letters.isEmpty() ? 1 : 0;
    }

    @Test
    void test() {
        String S = "{[()()]}";
        Assertions.assertThat(solution(S)).isEqualTo(1);
    }

}
