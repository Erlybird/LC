/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//TC: O(N+M)
//SC: O(M+N)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int var = 0;
        ListNode head = new ListNode(0);
        ListNode head2 = head;
        while(l1 != null || l2 != null || var != 0){
            int val1 = (l1 != null)? l1.val:0;
            int val2 = (l2 != null)? l2.val:0;
            int sum = val1 + val2 + var;
            int x= (sum) % 10;
            var = (sum)/10;
            head2.next = new ListNode(x);
            head2 = head2.next;
            if(l1 != null) l1= l1.next;
            if(l2 != null) l2 = l2.next;

        }
        return head.next;
    }
}