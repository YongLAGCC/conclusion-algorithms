public class BinaryTreeMaximumPathSum_124 {


   class TreeNode{
       TreeNode left;
       TreeNode right;
       int val = 0;
       public TreeNode(int v) {
           val = v;
       }
   }

        int max_sum = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if(root == null) return 0;
            max_gain(root);
            return max_sum;
        }
        public int max_gain(TreeNode root) {
            if(root == null) return 0;
            // max sum on left or right sub_tree of the root.
            int left_gain = Math.max(max_gain(root.left), 0);
            int right_gain = Math.max(max_gain(root.right), 0);
            // start a new path with root.val;
            int price_newPath = root.val + left_gain + right_gain;
            // update max sum whether to start a new path
            max_sum = Math.max(max_sum, price_newPath);
            // return max gain if continue this path.
            return root.val + Math.max(left_gain, right_gain);
        }

    }

