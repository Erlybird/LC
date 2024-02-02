//Solution: base case would be to check if it's a sorted array
// the min element in a rotated sorted array should be less than both it's neighbours
// important would be to check for the edge cases.
//TC: O(log N)
//SC: O(1)
class Solution {
    public int findMin(int[] nums) {
        int low =0;
        int n = nums.length ;
        int high = n-1;
        if(nums[low] <= nums[high])return nums[low];
        while(low<=high){
            int mid = low + (high-low)/2;
            // System.out.println("low =: "+ low +" high =: " + high + " mid =: "+ mid );
            // if(nums[mid]<= nums[low] && nums[mid]<= nums[high])return nums[mid];
            if((mid==0 || nums[mid] < nums[mid-1])
                    && (mid==n-1 || nums[mid] < nums[mid+1])) return nums[mid];
            else if(nums[mid] > nums[high]) low = mid+1;
            else high = mid - 1;
        }
        return -999;
    }
}