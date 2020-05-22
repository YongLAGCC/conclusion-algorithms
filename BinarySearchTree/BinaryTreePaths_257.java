import java.util.*;
public class BinaryTreePaths_257 {

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val = 0;
        public TreeNode(int v)
        {val = v; }
    }
//    Time comp: O(N) n is the length of the nodes.
//    Space comp: O(log n) when the tree are balanced. O(N) if the tree totally unbalanced
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {

            List<String> path = new LinkedList<>();
            if(root == null) return path;

            helper(root, path, "");
            return path;
        }
        public void helper(TreeNode root, List<String> path, String leaf) {
            if(root != null) {
                leaf +=Integer.toString(root.val); /// 1, -> 2 ->
                if(root.left == null && root.right == null)
                    path.add(leaf);
                else {
                    leaf +="->";
                    helper(root.left, path, leaf);
                    helper(root.right, path, leaf);
                }
            }
        }
    }
}
