import java.util.*;
public class PathSumII_113 {

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val = 0;
        public TreeNode(int v) {
            val = v;
        }
    }


        int res = 0;
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();

            if(root == null) return ans;
            helper(root, sum, ans, path);
            return ans;
        }
        public void helper(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> path) {
            if(root == null) return ;

            sum -= root.val;

            if(root.left == null && root.right == null) {
                if(sum == 0) {  //
                    path.add(root.val);
                    ans.add(new ArrayList<Integer>(path));
                    path.remove(path.size() - 1);
                }
                return ;
            }
            path.add(root.val);
            helper(root.left, sum, ans, path);
            helper(root.right, sum, ans, path);
            path.remove(path.size() - 1);

        }
    }


