import java.util.*;
public class ReverseLinkedListII_92 {
/*
    错误点： 除了核心的 for loop 部分，其他的都错掉了。 从dummy head开始
， 第一个for loop 找到的点是 m 的prev， so m - 1；


    Time complexity： O(n) each node over at most once except nodes after n.
    Space complexity: O(1). worked on the original list.
*/
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }

     dummy -> 1 -> 2 ->   3 -> 4 -> 5 -> null
     // prev   cur  NEXT  tep

     * }
     */

        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(head == null) return null;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;

            for(int i = 0; i < m - 1; ++i) {
                prev = prev.next;
            }

            ListNode cur  = prev.next;
            ListNode NEXT;

            for(int i = 0; i < n - m; ++i){
                NEXT = cur.next;

                cur.next = NEXT.next;
                NEXT.next = prev.next;
                prev.next = NEXT;

            }
            return dummy.next;
        }
    }

