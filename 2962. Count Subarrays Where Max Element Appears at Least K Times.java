//TC: O(N)
//SC: O(1)
//Solution: sliding window
// at each element check the total subarrays with maxElements == from the start- count the subarrays
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxi = 0;
    for(int num: nums) maxi = Math.max(maxi,num);
        long total =0;
        int start =0;
        int count =0;
        for(int end =0; end < nums.length; end++){
            if(nums[end] == maxi) count++;
            
            while(count == k && start < nums.length){
                if(nums[start] == maxi)count--;
                start++;
            }
            total += start;
            // System.out.println("start :" +  start + " end :" + end + " total: " + total);

        }
    return total;
    
    }
}