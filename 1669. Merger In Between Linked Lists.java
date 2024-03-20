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
//SC: O(0);
//Solution: Find all the pointers of the start of node removal and end of node removal, and the tail of 2nd list. then change the next pointers. 
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        if(a > b) return list1;
        
        ListNode pointerA = list1;
        ListNode pointerB = list1;
        
        //Finding the pointer at which 2nd list has to be added
        while(b >= 0){
            pointerB = pointerB.next;
            b--;
        }
        //Finding the pointer at which 1st list is ended
        while(a-1 > 0){
            pointerA = pointerA.next;
            a--;
        }
            ListNode pointerL2Tail = list2;
        //Finding the tail of 2nd list
        while(pointerL2Tail.next != null){
            pointerL2Tail = pointerL2Tail.next;
        }
        // changing the next pointers so as to remove a-b nodes in List1 and adding list2 in between
        pointerA.next = list2;
        pointerL2Tail.next = pointerB;

        return list1;
        
    }
}