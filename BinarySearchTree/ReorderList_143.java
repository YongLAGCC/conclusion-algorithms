public class ReorderList_143 {
//    Time complexity: O(n) n is the length of the nodes.
//    Space complexity: O(1), we did not create any more space.

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }

     null -> 1 -> 2 -> 3 ->4

     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            // find the middle node by two pointers, slow and fast.
            if(head == null) return  ;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode fast  = head;
            ListNode slow = head;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // reverse the second part of the list  需要三个变量。
            ListNode prev = null;
            ListNode curr = slow, temp;

            // null -> 4 -> 5 -> null
            //         pre   curr
            // null <- 4 <- 5 <- null
            //   1 -> 2 -> 3
            while(curr != null) {
                temp = curr.next;

                curr.next = prev;
                prev = curr;
                curr = temp; // 必须要有temp， 否则就有环了。 xxx
            }
            // System.out.print(prev.val);
            // merge the rest of the list with the first half of the list.
            ListNode first = head;
            ListNode second = prev; // curr 在上面已经等于 0 了。

            while(second.next != null) {
                temp = first.next;
                first.next = second;
                first = temp;

                temp = second.next;
                second.next = first;
                second = temp;
            }

        }
    }
}
