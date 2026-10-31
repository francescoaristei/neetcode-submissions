class Solution {
    private void moveArray(int[] arr, int i) {
        int temp = arr[i];
        while (i < arr.length - 1) {
            int next = arr[i + 1];
            arr[i + 1] = temp;
            temp = next;
            i++;
        }
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = 0;
        int n2 = 0;
        while (n2 < n && n1 < m + n) {
            if (nums1[n1] < nums2[n2]) {
                n1++;
            } else {
                moveArray(nums1, n1);
                nums1[n1] = nums2[n2];
                n1++;
                n2++;
            }
        }

        for (int t = 0; t < nums1.length; t++) {
            System.out.println(nums1[t]);
        }

        int i = nums1.length - 1;
        int j = nums2.length - 1;
        while (j >= n2) {
            nums1[i] = nums2[j];
            i--;
            j--;
        }
    }
}