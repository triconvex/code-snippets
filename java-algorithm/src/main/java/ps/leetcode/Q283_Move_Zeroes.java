package ps.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q283_Move_Zeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > zeroIndex) {
                    nums[zeroIndex] = nums[i];
                    nums[i] = 0;
                }
                ++zeroIndex;
            }
        }
    }

    @Test
    void test() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        Assertions.assertThat(nums).isEqualTo(new int[]{1, 3, 12, 0, 0});
    }

}
