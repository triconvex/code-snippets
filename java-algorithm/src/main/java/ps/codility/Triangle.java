package ps.codility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class Triangle {

    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            // (A[i] + A[i + 1] > A[i + 2]) <- edge case - integer overflow
            if (A[i] > A[i + 2] - A[i + 1]) {
                return 1;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] A = {10, 2, 5, 1, 8, 20};
        assertThat(solution(A)).isEqualTo(1);
    }

}
