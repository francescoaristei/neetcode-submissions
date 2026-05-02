/*
*
*
* [12, 13, 14, 16, 18, 22, 25, 29, 30, 34, 1, 3, 5, 6, 8, 9]
* 
* [29, 30, 34, 1, 3, 5, 6, 8, 9, 12, 13, 14, 16, 18, 22, 25]
*
*/

class Solution {
    private int binarySearch(int[] nums, int low, int high) {
        if (high < low) {

        }
        int mid = (low + high) / 2;
        
        // nums[mid] is the minimum
        if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }
        if (nums[mid] > nums[high]) {
            return binarySearch(nums, mid + 1, high);
        } else {
            return binarySearch(nums, low, mid - 1);
        }
    }

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // array non rotated
        if (nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        return binarySearch(nums, 0, nums.length - 1);
    }
}
