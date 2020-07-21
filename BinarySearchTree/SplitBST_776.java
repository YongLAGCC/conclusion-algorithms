public class SplitBST_776 {

//    Time comp: O(n), n is the nodes of the tree.
//    Space comp: O(n), n is the nodes of the tree.

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
    public class BST {

        public static class TreeNode {
            TreeNode left;
            TreeNode right;
            TreeNode next;
            int val;
            TreeNode(int x) {
                val = x;
            }
            public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
                val = _val;
                left = _left;
                right = _right;
                next = _next;
            }
        }
        public static void main(String args[]) {

            TreeNode root = new TreeNode(11);
            root.left = new TreeNode(7);
            root.right = new TreeNode(12);
            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(9);
            root.left.right.left = new TreeNode(8);
            root.left.right.right = new TreeNode(10);
            root.right.left = new TreeNode(14);
            root.right.right = new TreeNode(16);
            int V = 7;
            System.out.println(splitBST(root, V) );
        }

        public static TreeNode[] splitBST(TreeNode root, int V) {
            if(root == null) return new TreeNode [] {null, null};
            if (root.val > V) {
                TreeNode find [] = splitBST(root.left, V);
                root.left = find[1];
                find[1] = root;
                System.out.println(root.val + " left " + find[0]);
                return find;
            }
            else{  TreeNode find [] = splitBST(root.right, V);
                root.right = find[0];
                find[0] = root;
                System.out.println(root.val + "root " + find[1]);
                return find;
            }
        }
    }
}
