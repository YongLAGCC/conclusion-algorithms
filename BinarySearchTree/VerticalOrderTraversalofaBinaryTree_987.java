import javafx.util.Pair;

import java.util.*;
public class VerticalOrderTraversalofaBinaryTree_987 {


    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int v) {
            this.val = v;
        }

    }

    public static void main(String [] args) {
        System.out.println();
    }
   //  没有把case 过完， 垃圾，但是有qu的一道题。
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
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            // 建 一个column table， 放col 和 col的值。
            // Q: 放node 和 column。
            Map<Integer, ArrayList> columnTable = new HashMap<>();
            Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
            // node : 3,
            // col:   0,

            int column = 0;
            queue.offer(new Pair(root, 0)); // 3, 0
            int minCol = 0, maxCol = 0;
            while(!queue.isEmpty()) {
                Pair<TreeNode, Integer> curr = queue.poll();

                root = curr.getKey();  // 3,
                column = curr.getValue(); // 0,
                //   System.out.println(root + " , "+ column);
                if(root != null) {
                    if(!columnTable.containsKey(column)) { //
                        columnTable.put(column, new ArrayList<Integer>());  //  必须放type？？
                    }


                    columnTable.get(column).add(root.val);
                    System.out.println(root.val + " , " + column);
                    minCol = Math.min(minCol, column);
                    maxCol = Math.max(maxCol, column);

                    queue.offer(new Pair(root.left, column - 1) ); // put Pair type
                    queue.offer(new Pair(root.right, column + 1) );

                }
            }

            List<List<Integer>> ans = new ArrayList<>();
            for(int i = minCol; i <= maxCol; ++i)
                ans.add(columnTable.get(i) );


            return ans;
        }
    }
}
