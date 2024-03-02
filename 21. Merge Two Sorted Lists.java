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
//TC: O(M+N)
//SC: O(N)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while(list1 != null && list2 != null){
                if(list1.val <= list2.val){
                    result.next = new ListNode(list1.val);
                    list1 = list1.next;
                }else{
                    result.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                    result = result.next;

        }
        result.next = (list1 == null)? list2: list1;
        return dummy.next;
    }
}