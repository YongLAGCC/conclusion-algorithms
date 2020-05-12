public class SerializeandDeserializeBinaryTree297 {
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

//    痛点： 不能pass int 到方程，还有recursive 需要提高
//    错误点： serialize is okay.  deserialize need more careful to use recursive.
//    Time comp: Seri and Deseri uses O(n) n is the input nodes.
//    Space: take O(1) is seri, Deseri takes O(n) for the recursive
//


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     [2:00PM - 4:20PM]
     */



        // Encodes a tree to asingle string.
        public String serialize(TreeNode root) {
            StringBuilder ans = new StringBuilder();

            helper(root, ans);
            System.out.println(ans.toString());
            return  ans.toString();
        }

        public void helper(TreeNode root, StringBuilder sb) {

            if(root == null) {
                sb.append("null");
                sb.append(",");
                return ;
            } else {
                sb.append(Integer.toString(root.val) );
                sb.append(",");
            }
            helper(root.left, sb);
            helper(root.right, sb );

        }
        // 1, 2, null, null, 3, 4, null, null, 5, null, null,
        int index = -1;
        public TreeNode deserialize(String data) {
            if(data.length() == 0) return null;
            String charData [] = data.split(",");

            return helperDe(charData);
        }
        // 1,2,null,null,3,4,null,null,5,null,null,
//tree:1,
        public TreeNode helperDe(String [] data) {
            if(index >= data.length) return null;
            TreeNode root = null;

            index++;  // 0
            if(!data[index].equals("null") ) {
                root = new TreeNode(Integer.valueOf(data[index])); // 1, 2,

                root.left = helperDe(data); //
                root.right = helperDe(data);//null
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


