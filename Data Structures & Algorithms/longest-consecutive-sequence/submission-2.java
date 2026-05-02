/*
* There are two hints to understand:
*   - The start of a sequence is the number x such that x - 1 is not in nums
*   - You need to find a consecutive sequence, therefore once you find the 
*     first element x of the sequence, you need to check for x + 1, x + 2,....
* Given these two intuitions, the next thing that is necessary to do is to 
* copy all the elements of the input array in a HashSet so that is possible to
* check for the x - 1, x - 2, ...in O(1) time
*
* Time complexity: O(n)
* Space complexity: O(n)
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> numsSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }
        int result = 1;
        for (Integer num: numsSet) {
            if (!numsSet.contains(num - 1)) {
                int el = num;
                int temp = 1;
                while (numsSet.contains(el + 1)) {
                    temp += 1;
                    el = el + 1;
                }
                if (temp > result) {
                    result = temp;
                }
            } else {
                continue;
            }
        }
        return result;
    }
}
