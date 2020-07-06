public class FindMinimuminRotatedSortedArray153 {


    // time complexity: O(log n) by binary search, n is the length of the input array.
// space complexity: O(1), three variables define only.


        // 4, 5, 1, 2, 3
        public int findMin(int[] nums) {
            //check input valid or not
            // 完全没有想到思路。 lol
            int left = 0, right = nums.length - 1;
            if(nums[0] < nums[right]) return nums[0];
            if(nums.length < 1 || nums == null) return -1;

            if(nums.length == 1) return nums[0];
            //3,4,5,1,2
            //    l m r
            //4,5,6,7,0,1
            // l   m     r
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[left] > nums[left + 1]){
                    return nums[left + 1];
                }else {
                    if(nums[mid] < nums[right]) {
                        right = mid;
                    }
                    else {
                        left = mid;
                    }
                }
            }
            return -1;

        }
}
