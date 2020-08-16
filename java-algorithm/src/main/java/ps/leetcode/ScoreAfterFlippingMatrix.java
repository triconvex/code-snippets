package ps.leetcode;

import org.junit.Test;

public class ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] A) {
        int numberOfMatrix = A.length;
        int lengthOfMatrix = A[0].length;
        int result = (1 << (lengthOfMatrix - 1)) * numberOfMatrix; // if length of matrix = 4, 1--- 보장

        for(int i = 1; i < lengthOfMatrix; i++) {
            int numberOfOne = 0;

            for(int[] matrix : A) {
                numberOfOne += (matrix[i] == matrix[0]) ? 1 : 0; // 주어진 [0]와 [i] 같으면 1, 다르면 0 ([0]을 무조건 1로 만들기에)
            }

            // [i] 컬럼 값들의 합, numberOfOne이 numberOfMatrix - numberOfOne 보다 작으면 컬럼 자체를 토글해서 1로 바꿔주면 결국 둘 중 max값으로 합산 가능
            result += Math.max(numberOfOne, numberOfMatrix - numberOfOne) * (1 << (lengthOfMatrix - i - 1));
        }

        return result;
    }

    @Test
    public void test() {
        int[][] given = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        matrixScore(given);
    }

}
