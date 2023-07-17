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

//Time Complexity = O(N);
    //Space Complexity = O(1);
    
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;

    }

    private void helper(TreeNode root, List<Integer> result){
        //base
        if(root==null)return;
        result.add(root.val);
        helper(root.left,result);
        helper(root.right,result);
    }
}