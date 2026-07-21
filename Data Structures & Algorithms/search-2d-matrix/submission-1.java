class Solution {
    private boolean binarySearch(int low, int high, int[] nums, int target) {
        if (low > high) {
            return false;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[mid] > target) {
            return binarySearch(low, mid - 1, nums, target);
        }
        return binarySearch(mid + 1, high, nums, target);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(0, matrix[i].length - 1, matrix[i], target)) {
                return true;
            }
        }
        return false;
    }
}
