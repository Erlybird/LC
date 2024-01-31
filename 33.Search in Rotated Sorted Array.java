//TC = O(log N)
// SC = O(1)
// draw the graph of two possible scenarios and write down the conditions for all the cases possible between target, low, mid and high
// accumulate them in the form of statements

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while( low <= high){

            int mid = low + ( high - low )/2;

            if( nums[mid] == target) return mid;

            else if ( nums[mid] >= nums[low]){
                if(target < nums[mid] && target >=nums[low]){
                    high = mid - 1;
                }else{// for other two scenarios
                    low = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[high])
                    low = mid + 1;

                else high = mid - 1; // for other two scenarios
            }
        }

        return -1;
    }
}

