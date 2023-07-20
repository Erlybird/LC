/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//TIme Complexity = O(2N);
//Space Complexity = O(N);
class Solution {
    public Node copyRandomList(Node head) {

        //base
        if(head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node copycurr = new Node(head.val);
        Node copylist = copycurr;
        map.put(curr,copycurr);

        //Iterate through next pointers and create new nodes and put in HashMap

        while(curr.next != null){
            copycurr.next = new Node(curr.next.val);
            curr = curr.next;
            copycurr = copycurr.next;
            map.put(curr,copycurr);

        }
        curr= head;
        copycurr = copylist;

        //Iterate through random pointers and get references through HashMap and put it to them

        while(curr != null){
            copycurr.random = map.get(curr.random);
            copycurr = copycurr.next;
            curr= curr.next;
        }

        return copylist;
    }
}