import java.util.*;
public class BinaryTreeLevelOrderTraversal_102 {


//    Time Comp：O（n) n is the size of the tree nodes.
//
//    Space complexity : O(N) to keep the output structure which contains N node values.
//
        class TreeNode {
            TreeNode left;
            TreeNode right;
            int val = 0;
            public TreeNode(int v) {
                val = v;
            }
    }
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null) return ans;

            helper(root,  0);
            return ans;
        }
        public void helper(TreeNode root, int level) {
            if(root == null) return ;

            if(level == ans.size()) { // 3,
                ans.add(new ArrayList<>());//[[3],[9,20]]
            }

            ans.get(level).add(root.val);

            if(root.left != null) {
                helper(root.left, level + 1); //(9, 1)
            }

            if(root.right != null) {
                helper(root.right, level + 1);
            }

        }
    }

