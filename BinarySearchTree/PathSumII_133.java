import java.util.*;
public class PathSumII_133 {
//    Time complexity: O(n) n is the length of the nodes in binary tree.
//    Space complexity: O(n) created List in list to return + recursive O(n)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right)
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> solution = new ArrayList<>();

            if(root == null) return ans;

            searching(root, sum, solution, ans);
            return ans;

        }
        public void searching(TreeNode root,int sum, List<Integer> solution, List<List<Integer>>  ans ) {

            if(root == null) return;
            sum -= root.val;
            // if(sum == 0 && (root.left == null || root.right == null) ) {
            //     ans.add(solution);
            // }
            if(root.left == null && root.right == null) {
                if(sum == 0) {
                    solution.add(root.val);
                    ans.add(new ArrayList<Integer>(solution));
                    solution.remove(solution.size() - 1);
                }
                return ;
            }
            solution.add(root.val);
            searching(root.left, sum, solution, ans);
            searching(root.right, sum, solution, ans);
            solution.remove(solution.size() - 1);
        }

}
