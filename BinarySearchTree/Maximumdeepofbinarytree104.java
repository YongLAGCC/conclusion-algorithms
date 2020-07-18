public class Maximumdeepofbinarytree104 {

//    ```java
//Time complexity: O(n), n is the node of the tree.
//Space complexity: O(1).
///**
// * Definition for a binary tree node.
//  TreeNode() {
//        TreeNode left;
//        TreeNode right;
//        int val;
//        piblic TreeNode(int x){
//            this.val = x;
//        }
//    }



class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);

        return Math.max(left, right);
    }

}
