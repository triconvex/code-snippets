package ps.programmers;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 타겟넘버 {

    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    private int dfs(int[] numbers, int sum, int index, int target) {
        if(index == numbers.length) {
            return sum == target ? 1 : 0;
        }

        return dfs(numbers, sum + numbers[index], index + 1, target) + dfs(numbers, sum - numbers[index], index + 1, target);
    }


    @Test
    public void test() {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        assertThat(solution(numbers, target)).isEqualTo(5);
    }

}
