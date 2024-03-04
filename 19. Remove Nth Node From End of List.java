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
//Time Complexity = O(N)
//Space Complexity = O(1)
//Method: run fast pointer to n steps ahead and then move slow and fast pointer together, whereever the fast pointer reaches null, slow pointer reaches the nth node from the last. you can remove it now.
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //base
        if(head == null)return null;
        
        //logic
        ListNode fast = head;
        ListNode slow = head;
        
        //move the fast pointer n steps
        for(int i =0; i< n ; i++){
            // if(fast == null)return null;
            fast = fast.next;
        }
        if(fast == null) return head.next;
        while(fast.next!= null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
    }
}