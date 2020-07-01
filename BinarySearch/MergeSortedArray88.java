public class MergeSortedArray88 {
    // Time complexity: O(n) travse the arrays once.
    // Space comlexity: O(1) output space is same as input space.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two pointer
        int arr1 = m - 1;
        int arr2 = n - 1;
        int ans = m + n - 1;

        while (arr2 >= 0 && arr1 >= 0) {
            nums1[ans--] = nums1[arr1] > nums2[arr2] ? nums1[arr1--] : nums2[arr2--];
        }

        System.arraycopy(nums2, 0, nums1, 0, arr2 + 1);
    }

    }
