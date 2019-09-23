package leetcode;

public class SingleNumber {

    /*

    XOR
    a ^ b : 두 비트가 다르면 1, 아니면 0

     */

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

}
