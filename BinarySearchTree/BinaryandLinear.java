public class BinaryandLinear {



//https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/589342/Java-solution-or-O(logn)-or-beats-100-of-java-submissions



        public int search(int[] nums, int target) {
            // one pass, two cases, rotated point in left half or right half.
            int start = 0, end = nums.length - 1;
            while(start <= end) {
                int mid = start + (end - start) /2;
                // 4,5,6,7,8, 9 ,0,1,2
                // s       s  m    e
                // 8, 9, 0,1,2,4,5,6,7
                // s       m         e

                if(nums[mid] == target) return mid;

                else if( nums[start] <= nums[mid]) {
                    if(nums[start] <= target && nums[mid] > target)
                        end = mid - 1;
                    else  start = mid + 1;
                }
                else {
                    if(target <= nums[end] && target > nums[mid])
                        start = mid + 1;
                    else end = mid - 1;
                }
            }

            return -1;

    }
}
