
// Time complexity: O(n) n is the nodes of the tree.
//Space complexity: O(n) call the stack


import sun.text.normalizer.Utility;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.LinkedList;
import java.util.Queue;
public class BinaryTreeZigzagLevelOrderTraversal103 {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int v) {
            this.val = v;
        }

    }

//
//    错误点： 验证两次， 结果不可以用boolean 去判断储存方向。然后想到了 用level 的奇偶值 去 add value
//    Time complexity： O(n) Traverse all the nodes in the binary tree.
//    Space complexity: O(n) in the worse case. average
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
    public static void main(String args[]) {

    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;
        helper(root, 0, ans);
        return ans;
    }
    public void helper(TreeNode root, int depth, List<List<Integer>> ans ) {

        if(ans.size() == depth) {  // depth = 2, size = 2
            ans.add(new ArrayList<Integer>());  // ans.size() = 1;
        }

        if(depth % 2 == 0)
            ans.get(depth).add(root.val); // depth = 0 ans = [[3], [20,9], [15,]]
        else
            ans.get(depth).add(0, root.val);

        if(root.left != null)
            helper(root.left, depth + 1, ans);

        if(root.right != null)
            helper(root.right, depth + 1, ans);

    }
    }


