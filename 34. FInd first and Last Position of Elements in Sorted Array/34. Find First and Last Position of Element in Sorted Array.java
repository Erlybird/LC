//TC: O(logN)
// SC: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low =0;
        int n = nums.length;
        int high = n-1;

        // int left = -1;
        // int right = -1;

        int x= this.binarySearch(nums,0,n-1,target);
        int left =x ; int right = x;
        // System.out.print(x);
        if(x!= -1){
            while(left>0 && nums[left-1] == target){
                left = this.binarySearch(nums,0,left-1,target);
            }
            while(right < n-1 && nums[right+1] == target){
                right = this.binarySearch(nums,right+1,n-1,target);
            }
        }
        // System.out.print(left);
        return new int[]{left,right};

    }

    private int binarySearch(int[] nums, int l , int r ,int target){
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid] > target) r = mid-1;
            else{l=mid+1;}
        }
        return -1;
    }
}