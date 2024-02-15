// TC: O(N)
// SC: O(N)
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int positiveIdx =0;
        int negativeIdx = 1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] >0){
                result[positiveIdx] = nums[i];
                positiveIdx +=2;
            }else{
                result[negativeIdx] = nums[i];
                negativeIdx += 2;
            }
        }
        return result;
    }
}