//Time Complexity = O(N)
// Space Complexity = O(1)
// Solution: take three pointers, left, right, and pointer; when value of pointer is 0, swap with left and pointer++,left++ and when value of pointer is 2, just swap with right and right--; which implies for sure elements to the right side of right pointer is 2 and elements to the left of left pointer are 0; which will automatically sort the colours.
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int pointer = 0;
        int right = nums.length -1;

        while(pointer <= right){
            if(nums[pointer] == 2){
                swap(nums,pointer,right);
                right--;
            }else if(nums[pointer] ==0){
                swap(nums,pointer,left);
                pointer++;
                left++;
            }else if(nums[pointer] ==1){
                pointer++;
            }
        }
        // return nums;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}