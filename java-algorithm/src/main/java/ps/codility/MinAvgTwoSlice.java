package ps.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MinAvgTwoSlice {

    public int solution(int[] A) {
        int result = Integer.MAX_VALUE;
        double minimumAverage = Double.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            double averageOfPair = Double.MAX_VALUE;
            if (i + 1 < A.length) {
                averageOfPair = (double) (A[i] + A[i + 1]) / 2;
            }

            double averageOfTriple = Double.MAX_VALUE;
            if (i + 2 < A.length) {
                averageOfTriple = (double) (A[i] + A[i + 1] + A[i + 2]) / 3;
            }

            double currentMinimumAverage = Math.min(averageOfPair, averageOfTriple);

            if (minimumAverage > currentMinimumAverage) {
                minimumAverage = currentMinimumAverage;
                result = i;
            }
        }

        return result;
    }

    @Test
    public void test() {
        int[] A = {4, 2, 2, 5, 1, 5, 8};
        assertThat(solution(A)).isEqualTo(1);
    }

}
