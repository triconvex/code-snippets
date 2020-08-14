package ps.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Prefix Sum 이용
 * O(N + M)
 * https://codility.com/media/train/3-PrefixSums.pdf
 */
public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int M = P.length;
        int length = S.length();
        int[] result = new int[M];

        int[] A = new int[length + 1];
        int[] C = new int[length + 1];
        int[] G = new int[length + 1];

        char[] letters = S.toCharArray();

        for (int i = 0; i < length; i++) {
            char letter = letters[i];

            switch (letter) {
                case 'A':
                    ++A[i + 1];
                    break;
                case 'C':
                    ++C[i + 1];
                    break;
                case 'G':
                    ++G[i + 1];
                    break;
            }

            A[i + 1] += A[i];
            C[i + 1] += C[i];
            G[i + 1] += G[i];
        }

        for (int i = 0; i < M; i++) {
            int left = P[i];
            int right = Q[i];
            int value = 4;

            if (A[right + 1] != A[left]) {
                value = 1;
            } else if (C[right + 1] != C[left]) {
                value = 2;
            } else if (G[right + 1] != G[left]) {
                value = 3;
            }

            result[i] = value;
        }
        return result;
    }

    @Test
    public void test() {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        assertThat(solution(S, P, Q)).isEqualTo(new int[]{2, 4, 1});
    }

}
