public class KthSmallestElementinaSortedMatrix378 {
    // Time complexity:  For a one-dimensional binary search over an array with NN elements, the complexity comes out to be O(log(N))O(log(N)).
    //For our scenario, we are kind of defining our binary search space in terms of the minimum and the maximum numbers in the array. Going by this idea, the complexity for our binary search should be O(log(\text{Max}-\text{Min}))O(log(Max−Min)) where \text{Max}Max is the maximum element in the array and likewise, \text{Min}Min is the minimum element.
    public int kthSmallest(int[][] matrix, int k) {
        // find middle value. find a pair value in matrix, with the value closest to middle.
        // use binary search to count and update pair value. if count == k, return
        // otherwise, find largest val nearest to mid,
        // compare all the value in largest value part or smallest value part.


        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n - 1][n - 1];
        while(start < end) {
            int mid = start + (end - start) / 2;

            int closestPair[] =  { matrix[0][0], matrix[n - 1][n - 1] };
            int count = this.countEquals(matrix, mid, closestPair);

            if(count == k) return closestPair[0];
            if(count < k) start = closestPair[1];  // search higher
            else end = closestPair[0];
        }
        return start;

    }
    public int countEquals(int [][] matrix, int mid, int [] closestPair) {
        int count = 0;
        int row = matrix.length - 1, col = 0;

        while(row >= 0 && col < matrix.length) {

            if(matrix[row][col] > mid) {
                closestPair[1] = Math.min(closestPair[1], matrix[row][col]);
                row--;
            }  else {
                closestPair[0] = Math.max(closestPair[0], matrix[row][col]);
                count +=row + 1;  /// ???
                col++;
            }
        }
        return count;
    }
}
