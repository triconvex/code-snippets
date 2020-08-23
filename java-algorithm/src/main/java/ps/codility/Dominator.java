package ps.codility;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Dominator {

    public int solution(int[] A) {
        Map<Integer, Integer> elementCounts = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int currentCount = elementCounts.getOrDefault(A[i], 0);
            if (currentCount > A.length / 2 - 1) {
                return i;
            }
            elementCounts.put(A[i], currentCount + 1);
        }
        return -1;
    }

    @Test
    void test() {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        Assertions.assertThat(solution(A)).isEqualTo(7);
    }

}
