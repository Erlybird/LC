/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//TC: O(N)
// SC: O(N/2)
// Solution : Using BST, whenever we are removing the first element of the queue after the addition from previous nodes of upper level, we will update the leftMost node to this Node.
class Solution {
    public int findBottomLeftValue(TreeNode root) {

        TreeNode leftMost = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i =0; i< size; i++){
                TreeNode curr = q.poll();
                
                // leftmost node of a level
                if(i==0) leftMost = curr;
                
                if( curr.left != null){
                    q.add(curr.left);

                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return leftMost.val;
    }
}