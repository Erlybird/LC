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

// TC: O(N)
    // SC: O(N)
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        // List<TreeNode> queue = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return new ArrayList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i < size ; i++){
                TreeNode curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                max = Math.max(max,curr.val);
                // queue.remove(i);

            }
            result.add(max);
            max = Integer.MIN_VALUE;

        }
        return result;
    }
}