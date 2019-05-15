import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);    
        for (int i = 0; i < nums.length; i++) {                                
            Integer index = map.get(target - nums[i]);
            if (Objects.nonNull(index)) {
                return new int[]{index, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}

