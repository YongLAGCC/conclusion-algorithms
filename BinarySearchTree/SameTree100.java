public class SameTree100 {
//错误点， return is not smart. check the conditions are okay, need improve.
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(q == null && p == null) return true;
            if(q == null || p == null) return false;

            if(p.val != q.val) return false;

            return  isSameTree(q.left, p.left) &&
                    isSameTree(q.right, p.right);
        }

}
