package ps.ww;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class Q1 {

    public int solution(String s) {
        int count = 0;
        int number = Integer.parseInt(s, 2);
        while (number != 0) {
            ++count;
            if (number % 2 == 0) {
                number >>= 1;
            } else {
                --number;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertThat(solution("011100")).isEqualTo(7);
    }

}
