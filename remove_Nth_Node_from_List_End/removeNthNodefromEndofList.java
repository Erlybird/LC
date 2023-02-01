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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode dummy= new ListNode(0);
        dummy.next= head;
        ListNode var= head;
        while(var != null){
            count++;
           var = var.next;
        }
       var = dummy;
        count= count-n;
        while (count > 0){
            count--;
            var=var.next;
            
        }
        // for(int i =1 ; i<= count; i++){
            // var= var.next;
            
        // }
        var.next= var.next.next;
        
        return dummy.next;
        
            
    }
}