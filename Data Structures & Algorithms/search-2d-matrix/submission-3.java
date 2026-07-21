class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;

        int row = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] > target) {
                high = mid - 1;
                continue;
            }
            if (matrix[mid][matrix[mid].length - 1] < target) {
                low = mid + 1;
                continue;
            }
            row = mid;
            break;
        }

        if (row == -1) {
            return false;
        }

        int start = 0;
        int end = matrix[row].length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] > target) {
                end = mid - 1;
                continue;
            }
            start = mid + 1;
        }
        return false;
    }
}
