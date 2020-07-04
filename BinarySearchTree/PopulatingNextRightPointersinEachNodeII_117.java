public class PopulatingNextRightPointersinEachNodeII_117 {

//    错误点： 了解不彻底，，
//
//    // next 记录 leftMost， 一直记录， 如果右边的。next 没有了， 就去外边的loop 找leftMost。直到最底部的node。 不在更新next 和pre
//// pre： 领头 为下一行，也是return的重要实行处
//    Time comp: O(n) iterrite all the nodes once.
//    Space com: O(1) by use pointer.
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

    };
    */
// 1 #, pop(1), left, right, if #,
    class Solution {
        public Node connect(Node root) {
            if(root == null) return root;
            Node pre;
            Node next;

            Node mostLeft = root;
            while(mostLeft != null) {
                pre = null;
                next = null;
                while(mostLeft != null) {
                    if(next == null) {
                        next = (mostLeft.left != null) ? mostLeft.left : mostLeft.right;
                    } // 用了next的 数据。

                    if(mostLeft.left != null) {
                        if(pre != null) {
                            pre.next = mostLeft.left;
                            pre = pre.next;
                        } else {
                            pre = mostLeft.left;
                        }
                    }

                    if(mostLeft.right != null) {
                        if(pre != null) {
                            pre.next = mostLeft.right;
                            pre = pre.next;
                        } else {
                            pre = mostLeft.right;
                        }
                    }
                    mostLeft = mostLeft.next;
                }

                mostLeft = next;
            }
            return root;
        }
    }
}
