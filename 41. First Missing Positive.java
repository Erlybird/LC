//TC: O(N)
//SC: O(1)
// Solution: in this solution, the max number which can be given out would be n+1,
//so if we check for the elements less than n, if they are not present we can return that int.
//cycle sort
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i =0;
        while(i< nums.length){
            // 3,4,-1,1
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] -1);
            }
            else i++;
            
        }
        
        for(int j =0; j < nums.length; j++){
            if(nums[j] != j+1) return j+1;
        }
        return nums.length+1;
    }
    
    private void swap(int[] nums,int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}