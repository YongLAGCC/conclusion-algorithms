public class PopulatingNextRightPointersinEachNode_116 {

    //开辟新的题型，

    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    */

        public Node connect(Node root) {
            if(root == null) return root;
            Node leftMost = root;

            while(leftMost.left != null) { // 1,
                Node head = leftMost;        // 1,

                while(head != null) {   //记得是这层操作下一层
                    head.left.next = head.right;  // 2 -> 3
                    if(head.next != null) { //记得是这层操作下一层

                        head.right.next = head.next.left;
                    }
                    head = head.next;
                }
                leftMost = leftMost.left;
            }
            return root;

        }
    }

