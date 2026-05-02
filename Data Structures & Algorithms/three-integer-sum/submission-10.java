/*
* [-1, 0, 1, 2, -1, -4, 5, -6, 1, 0, 0, 3, -1, -2, 4, 5]
* 
* [-6, -4, -2, -1, -1, -1, 0, 0, 0, 1, 1, 2, 3, 4, 5, 5]
* System.out.printf("%d: %d, %d: %d, %d: %d\n", i, nums[i], j, nums[j], k, nums[k]);
* 
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] > (-1) * nums[i]) {
                    k--;
                } else if (nums[j] + nums[k] < (-1) * nums[i]) {
                    j++;
                } else {
                    List<Integer> triplet = List.of(nums[i], nums[j], nums[k]);
                    result.add(triplet);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
