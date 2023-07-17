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
//Space Complexity = O(N);
//Logic: InOrderTraversal for a BST should be sorted else it aint a BST
class Solution {
    public boolean isValidBST(TreeNode root) {
        //base
        if(root==null || (root.left == null && root.right == null))return true;
        List<Integer> array = new ArrayList<>();
        inOrder(root,array);
        for(int i =0; i<array.size();i++){
            if(i==array.size() -1){
                if(array.get(i) <= array.get(i-1))return false;
            }else{
                if(array.get(i) >= array.get(i+1))return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root, List<Integer> array){
        if(root == null)return;
        inOrder(root.left,array);
        array.add(root.val);
        inOrder(root.right,array);
    }
}