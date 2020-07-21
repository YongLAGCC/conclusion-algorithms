import java.util.*;
public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {

//    错点： 看到了第一个node in preorder中是 root， 但是后面有点乱。
//    Time comp： O（n) n is the nodes for output.
//    Space comp: O(n log n), recurrsive call.

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }

      }

    class Solution {

        HashMap<Integer, Integer> idx_graph = new HashMap<>();
        int pre_idx = 0;

        public TreeNode helper(int[] preorder, int[] inorder, int i_left, int i_right) {
            if(i_left == i_right)
                return null;

            int root_val = preorder[pre_idx];// 3,
            TreeNode root = new TreeNode(root_val);  // preorder [3,9,20,15,7]

            int index = idx_graph.get(root_val); //inorder      [9,3,15,20,7]
            pre_idx++;

            root.left = helper( preorder, inorder,i_left, index);
            root.right = helper(preorder, inorder, index + 1, i_right);

            return root;
        }
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // first node of preorder is the root, in the inorder tree. two side of the root is right root and left root.
            // preOrder to know the root. Inorder to divided into left and right part.
            //create two arrays inOrder and preOrder.
            // recurrsively call base on the index of the root.


            int idx = 0;
            for(Integer val: inorder)
                idx_graph.put(val, idx++);

            return helper( preorder, inorder, 0, inorder.length);
        }

    }

}
