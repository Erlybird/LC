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
    public String gameResult(ListNode head) {
        
        int oddcount =0;
        int evencount = 0;
        
        while(head != null && head.next != null){
            
            if(head.val > head.next.val){
                evencount++;
            }else oddcount++;
            head = head.next.next;
        }
        
        if(oddcount > evencount) return "Odd";
        else if ( oddcount < evencount) return "Even";
        else return "Tie";
        
    }
}