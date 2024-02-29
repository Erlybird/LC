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
 //SC: O(N)
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root.val % 2 ==0) return false;
        q.add(root);
        int idx = 0;
        int prev = Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            //idx = 0; odd numbers ; increasing
            
            
            for(int i =0; i< size; i++){
                // System.out.println(idx);
                TreeNode curr = q.poll();
                int k = idx%2;
                
                if(k ==0){
                    if(curr.val <= prev)return false;
                }else{
                    if(curr.val >= prev) return false;
                }
                if(curr.left != null){
                    if(curr.left.val %2 != k) return false;
                    q.add(curr.left);
                }
                if(curr.right != null){
                    if(curr.right.val %2 != k) return false;
                    q.add(curr.right);
                }
                prev = curr.val;
            }
            idx++;
            if(idx % 2 == 0) prev = Integer.MIN_VALUE;
            else prev = Integer.MAX_VALUE;
        }
        return true;
    }
}