import apple.laf.JRSUIUtils;

public class DeleteNodeinaBST_450 {

//    Time： O(H), H is hte high of the tree.
//    Space: O(h), h is hte high of the tree.

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val =0;
        public TreeNode(int v) {
            val = v;

        }
    }

        public int precessor(TreeNode root) {
            root = root.right;
            while(root.left != null) {
                root = root.left;
            }
            return root.val;
        }
        public int preprocessor(TreeNode root) {
            root = root.left;
            while(root.right != null) {
                root = root.right;
            }
            return root.val;
        }

        public TreeNode deleteNode(TreeNode root, int key) { //(1, 2)
            if(root == null) return null;

            if(root.val > key) {
                root.left = deleteNode(root.left, key); // (34, 34)
            } else if(root.val < key) {
                root.right = deleteNode(root.right, key);
            } else {
                if(root.left == null && root.right == null) {
                    return root = null;
                } else if(root.right != null) {//40
                    root.val  = precessor(root);//34 -> 36
                    root.right = deleteNode(root.right, root.val);//(40,34)
                    //33                 //   36,         36
                } else {
                    root.val =  preprocessor(root);
                    root.left = deleteNode(root.left, root.val);

                }
            }
            return root;
        }

    }

