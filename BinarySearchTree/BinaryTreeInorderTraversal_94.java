import java.util.*;
public class BinaryTreeInorderTraversal_94 {

//    Time comp: O(n) n is  the tree nodes.
//    Space comp: O(log n), n is the tree nodes.  worse case is O(n).

   class TreeNode{
       TreeNode left;
       TreeNode right;
       int val = 0 ;
       public TreeNode(int v) { val = v; }
   }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();

            if(root == null) return list;


            helper(root, list);
            return list;
        }
        public void helper(TreeNode root, List<Integer> list) {
            if(root == null)
                return ;


            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);

        }
}
