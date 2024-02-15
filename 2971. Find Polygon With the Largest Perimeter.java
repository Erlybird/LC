//TC: NlogN
//SC: O(1)
class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        if(nums.length< 3)return -1;
        long sum =0;
        for(int i =0; i< nums.length; i++){
            sum += nums[i];

        }
        for(int i = nums.length -1; i>=0; i--){
            sum -= nums[i];
            if(sum > nums[i])return sum + nums[i];
        }

        return -1;
    }
}