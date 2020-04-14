import java.util.*;
public class CheckCompletenessofaBinaryTree_958 {

//    Two ways to solve
//1, BFS:


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            if(root != null) q.offer(root);

            boolean end = false;
            while(!q.isEmpty()) {
                TreeNode t = q.poll();
                if(t == null) {
                    end = true;
                } else {
                    if(end) return false;
                    q.offer(t.left);
                    q.offer(t.right);
                }
            }
            return true;
        }
    }


// DFS:

}
