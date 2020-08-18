package ps.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MaxCounters {

//    Arrays.fill 때문에 타임아웃 케이스 발생
//    public int[] solution(int N, int[] A) {
//        int[] result = new int[N];
//        int maxCounter = 0;
//
//        for (int i : A) {
//            if (i == N + 1) {
//                Arrays.fill(result, maxCounter);
//            } else {
//                ++result[i - 1];
//                maxCounter = Math.max(maxCounter, result[i - 1]);
//            }
//        }
//
//        return result;
//    }

    //O(N + M)
    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int maxCounter = 0;
        int lastMaxCounter = 0;

        for (int i : A) {
            if (i == N + 1) {
                lastMaxCounter = maxCounter;
            } else {
                result[i - 1] = Math.max(result[i - 1], lastMaxCounter) + 1;
                maxCounter = Math.max(result[i - 1], maxCounter);
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(result[i], lastMaxCounter);
        }

        return result;
    }

    @Test
    public void test() {
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};

        assertThat(solution(N, A)).isEqualTo(new int[]{3, 2, 2, 4, 2});
    }

}
