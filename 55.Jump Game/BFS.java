//Time Complexity = O(N^N) Might be wrong.
//Space Complexity = O(N) + O(N)
//BFS
//Method: Put indices in the queue and put its children in the queue, add them in the hashset, for processing the same element next time, we wouldn't be needing to put it in the queue again
//if last index goes in the queue, then return true
class Solution {
    public boolean canJump(int[] nums) {
        //set and queue
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(0); set.add(0);
        // int i =0;
        while(!q.isEmpty()){
            int currIdx = q.poll();
            int k = nums[currIdx];
            for(int j =0; j <= k && currIdx+j < nums.length; j++){
                if(currIdx+j == nums.length -1) return true;
                if(!set.contains(currIdx+j)){
                    q.add(currIdx+j);
                    set.add(currIdx+j);
                }
            }

        }
        return false;
    }
}