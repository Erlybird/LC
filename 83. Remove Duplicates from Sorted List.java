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

// TC: O(N)
// SC: O(1)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while( fast != null && fast.next != null){
            
            while(fast.next!= null && fast.val == fast.next.val ){
                fast = fast.next;
            }
            slow.next = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        
        return head;
    }
}