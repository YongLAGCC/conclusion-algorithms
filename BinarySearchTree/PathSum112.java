public class PathSum112 {

//    Time complexity: O（n) n is the # of the tree nodes
//    Space complexity: recursive the tree takes O(n). if unbalance tree, in the worse case, it takes O(n), the tree has one leave with n nodes

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }



     * }
     */




        public boolean hasPathSum(TreeNode root, int sum) {
            if(root == null) return false;
            sum -= root.val;

            if(root.left == null && root.right == null) return sum == 0;

            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }

    }

