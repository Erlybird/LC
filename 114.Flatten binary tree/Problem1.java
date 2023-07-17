//Time Complexity = O(N)
//Space Complexity = O(1)
//Logic: Go to root.left leaf, break the node root.left and put it at root.right while transfer he existing root.right to newly connected root.left->root.right at the end point as root.right
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
class Solution {
    public void flatten(TreeNode root) {
        //base
        if(root==null)return ;

        flatten(root.left);

        swap(root,root.left,root.right);

        flatten(root.right);


    }

    private void swap(TreeNode root,TreeNode left, TreeNode right){
        if(root.left != null){
            TreeNode temp = right;
            root.right = root.left;
            root.left = null;
            while(root.right != null){
                root = root.right;
            }
            root.right = temp;
        }
    }
}