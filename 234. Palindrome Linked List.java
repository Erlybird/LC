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

//TC: O(3N)
//SC: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)return true;
        ListNode fast = head;
        ListNode slow = head;
        
        //Find out the end of the firsthalf //O(N)
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        
        // reverse the second half of the linked list
        //O(N)
        ListNode reversed = reverseList(slow.next);
        slow.next = null;
        
        // reversed will be same length as head if even numbers are present in the list
        //and reversed will be less by one number if odd numbers exist
        
        //check if each and every value are same in the linked lists
        //O(N/2)
        while( reversed != null){
            if(head.val != reversed.val)return false;
            head = head.next;
            reversed = reversed.next;
        }
        return true;
        
    }
    
    private ListNode reverseList(ListNode head){
        
        
        ListNode prev = null;
        // ListNode dummy;
        while(head != null ){
        ListNode dummy = head.next;
            head.next = prev;
            prev = head;
            head = dummy;
        }
        return prev;
    }
}