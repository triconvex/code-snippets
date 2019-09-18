package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    //ex input: 1,2,3
    //call 0: add 1 //1
    //call 1: skip 1, add 2 //1,2
    //call 2: skip 1, skip 2, add 3 //1,2,3
    //call 3: base case, 1,2,3 -> add to result
    //call 2: remove 3, return //1,2
    //call 1: remove 2, add 3 //1,3
    //call 4: skip 1, add 2 //1,3,2
    //call 5: base case, 1,3,2 -> add to result
    //call 4: remove 2, skip 3 return //1,3 -> //2,1,3 ......

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, result, temp);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp) {
        //base case
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        //recursion
        for(int num : nums) {
            if(temp.contains(num)) {
                continue;
            }

            temp.add(num);
            backtrack(nums, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
