/* Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n). */

//Sorting would take longer - not an optimal soln
class Solution {
    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer second_max = null;
        Integer third_max = null;

        for (Integer num : nums) {

            if (max == null || num > max) {
                third_max = second_max;
                second_max = max;
                max = num;
            } else if (second_max == null || num > second_max) {
                third_max = second_max;
                second_max = num;
            } else if (third_max == null || num > third_max) {
                third_max = num;
            }
        }

        if (third_max == null) {
            return max;
        }

        return third_max;
    }
}