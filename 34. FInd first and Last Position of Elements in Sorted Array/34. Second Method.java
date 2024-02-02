//TC: O(logN)
//SC: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums,target,true);
        if(first == -1) return new int[]{-1,-1};
        int last = this.binarySearch(nums,target,false);

        return new int[]{first, last};

    }
    private int binarySearch(int[] nums, int target, boolean isFirst){
        int low=0;
        int n = nums.length;
        int high = n-1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]==target){
                //check if the index is index if for starting index or ending index
                if(isFirst){
                    //for first index
                    if(mid > 0 && nums[mid-1] == target){
                        high = mid-1;
                    }else return mid;
                }
                else{
                    //for last index
                    if(mid < n-1 && nums[mid+1] == target){
                        low = mid + 1;
                    }else return mid;
                }
            }else if(nums[mid] > target) high = mid -1;
            else low = mid + 1;
        }
        return -1;
    }
}