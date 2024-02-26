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
//TC: O(N) - total nodes
//SC: recursive stack O(N)
class Solution {
    int max_Diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        maxLengthOfRightOrLeft(root) ;
        return max_Diameter;
    }

    private int maxLengthOfRightOrLeft(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        else{
            int maxLengthRight = maxLengthOfRightOrLeft(root.left);
            int maxLengthLeft = maxLengthOfRightOrLeft(root.right);
            max_Diameter = Math.max( maxLengthRight + maxLengthLeft , max_Diameter);
            return 1 + Math.max(maxLengthLeft,maxLengthRight);
        }
    }
}