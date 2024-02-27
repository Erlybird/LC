//TC: O(N)
//SC: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length ==0 || nums == null) return 0; 
        int j=-1;
        int i =0;
        while(i < nums.length){
            int k = nums[i];
            while(i != nums.length - 1 && nums[i+1] == k){
                i++;
            }
            j++;
            nums[j] = nums[i];
            i++;
        }
        return j+1;
    }
}