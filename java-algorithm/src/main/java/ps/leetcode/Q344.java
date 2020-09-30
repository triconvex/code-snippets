package ps.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while(left < right) {
            swap(left, right, s);
            left++;
            right--;
        }
    }

    private void swap(int a, int b, char[] s) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }

    @Test
    void test() {
        char[] in = {'h','e','l','l','o'};
        char[] out = {'o','l','l','e','h'};
        reverseString(in);
        Assertions.assertThat(in).isEqualTo(out);
    }

}
