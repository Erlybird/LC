//Solution: Because we can give any peak element as output. If the mid element is greater than mid+1, then a peak should compulsorily be between low and mid , similarly if mid+1 is greater than mid-1, then a peak should be there compulsorily between mid and high
//TC: O(logN)
//SC: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int low =0;
        int high = nums.length - 1;
        // int mid = -1;
        while(low <= high){
            int mid = low +(high-low)/2;
            if((mid == nums.length -1 || nums[mid]>nums[mid+1])
                    && (mid == 0 || nums[mid] > nums[mid-1]))
                return mid;
            else if(mid >0 && nums[mid] < nums[mid-1]) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}