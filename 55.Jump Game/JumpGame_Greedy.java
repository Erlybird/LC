//Time Complexity: O(N)
//Space Complexity : O(1)
//Method: Greedy approach
//come from the last , check if last element can be reached by any of the elements to the left, lly for all the elements to the left which implies, currIdx + nums[currIdx] >= nums.length -1, if this expression is valid, then the new target would be currIdx in the place of nums.length-1; target should be equal to 0 for jump possibility.

class Solution {
    public boolean canJump(int[] nums) {
        //base
        if(nums.length < 2)return true;
        int target = nums.length -1;

        for(int currIdx = nums.length -2 ; currIdx >= 0 ; currIdx--){
            if(currIdx + nums[currIdx] >= target){
                target = currIdx;
            }
            if(target==0)return true;
        }


        return false;
    }
}