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
//TIme Complexity = O(N);
//Space Complexity = O(N);
class Solution {
    public Node copyRandomList(Node head) {

        //base
        if(head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node copylist = new Node(head.val);
        Node copycurr = copylist;
        map.put(curr,copycurr);

        while(curr != null){
            copycurr.random = clone(curr.random,map);
            copycurr.next = clone(curr.next,map);
            curr = curr.next;
            copycurr = copycurr.next;
        }
        return copylist;
    }

    private Node clone(Node node, HashMap<Node,Node> map){
        if(node == null) return null;
        if(!map.containsKey(node)){
            Node copy = new Node(node.val);
            map.put(node,copy);
        }
        return map.get(node);
    }
}