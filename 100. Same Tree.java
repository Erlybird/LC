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
// TC : O(2N)
    // SC: O(2N) stack
    

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null && q != null) || (q == null && p != null))return false;
        else if(p.val != q.val) return false;
        else{
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}