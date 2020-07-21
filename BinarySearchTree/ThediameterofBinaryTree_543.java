
public class ThediameterofBinaryTree_543{


    //错点： 没有认真考率去设置一个比较的 变量。
//        Time comp： O(N), n is the length of the nodes in the tree.
//        Space comp: O(log n) is the balanced. O(n) if the tree totally unbalanced.
//
//        ????  (Time Complexity: O(N). We visit every node once.
//        Space Complexity: O(N), the size of our implicit call stack during our depth-first search.
//        )
    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int val = 0;

        public TreeNode(int v) {
            this.val = v;
        }

    }




    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode root){
        if (root == null)
            return 0;
        int Hleft = 0, Hright = 0;
        Hleft = depth(root.left);
        Hright = depth(root.right);

        ans = Math.max( Hleft + Hright, ans);

        return Math.max(Hleft, Hright) + 1;

    }
}

