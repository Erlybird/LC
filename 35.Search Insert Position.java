// TC= O(logN)
//SC =O(1)
// in binary search the initialization of mid variable should be inside the while loop
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low =0;
        int high = nums.length -1;
        // System.out.print(high,low, mid);
        int mid =0;
        while(low <= high){
            mid = low + (high-low)/2;

            if(nums[mid]==target)return mid;
            else if(nums[mid]>target) high = mid-1;
            else low = mid +1;
        }
        return low;
    }

//     private boolean binarySearch(int[] nums, int target){

//     }
}