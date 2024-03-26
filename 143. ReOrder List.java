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
//TC: O(N)
//SC: O(1)
class Solution {
    public void reorderList(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nextd = reverse(slow);
        
        ListNode first = head;
        ListNode dummy;
        while(nextd.next != null){
            dummy = first.next;
            first.next = nextd;
            first = dummy;
            
            dummy = nextd.next;
            nextd.next = first;
            nextd = dummy;
        }
    }
    
    private ListNode reverse(ListNode head){
        
        ListNode prev = null;
        
        while(head != null){
            ListNode dummy = head.next;
            head.next = prev;
            prev = head;
            head = dummy;
        }
        return prev;
    }
}