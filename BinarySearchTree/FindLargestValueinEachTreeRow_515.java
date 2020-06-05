import java.util.*;
public class FindLargestValueinEachTreeRow_515 {

//    Time comp: O(n) n is the tree nodes of the tree.
//    Space comp: O(n) call the stack of nodes times
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    class TreeNode {

        TreeNode left;
        TreeNode right;
        int val = 0;
        TreeNode(int v) {
            this.val =v;
        }}

        public List<Integer> largestValues(TreeNode root) {
            //question: repeat value? full binary tree? do left and right child tree have same high?
            List<Integer> ans = new ArrayList<>();
            if(root == null) return  ans;
            helper(root, ans, 0);
            return ans;
        }
        public void helper(TreeNode root, List<Integer> ans, int level) {
            if(root == null) return ;
            if(level == ans.size())
                ans.add(Integer.MIN_VALUE);

            int val = Math.max(ans.get(level), root.val);

            ans.set(level, val);
            helper(root.left, ans, level+1);
            helper(root.right, ans, level+1);

        }


//      Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//         List<Integer> res = new ArrayList<>();
//         if(root == null) return res;
//         int level = 0;

//         queue.offer(new Pair<TreeNode, Integer>(root, level)); // (1,0),()5,3,9
//         while(!queue.isEmpty()) {

//             Pair<TreeNode, Integer> pairs = queue.poll();//(1,0)
//             root = pairs.getKey(); //3
//              level = pairs.getValue(); //1

//             if(res.size() == level)
//                 res.add(Integer.MIN_VALUE);


//             int val = Math.max(res.get(level), root.val);
//             res.set(level, val);// (0, 1)
//           if(root.left != null)
//             queue.offer(new Pair(root.left, level +1) );
//            if(root.right != null)
//             queue.offer(new Pair(root.right, level +1) );
//         }
//         return res;
// }
    }

