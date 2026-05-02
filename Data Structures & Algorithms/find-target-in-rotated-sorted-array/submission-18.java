/*
* Idea: I can define the algorithm to find the min element
* extract its index, and from there I am able to know the two
* ordered halves of the array.
* From there I just need to apply binary search on each using the
* target.
* Complexity is still O(log n)
*/

class Solution {
    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return - 1;
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int minIndex = 0;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                minIndex = mid;
                break;
            }
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (minIndex == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        } else {
            int maxIndex = minIndex - 1;
            int result = binarySearch(nums, 0, maxIndex, target);
            if (result == - 1) {
                result = binarySearch(nums, minIndex, nums.length - 1, target);
            }
            return result;
        }
    }
}
