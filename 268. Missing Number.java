//TC: O(N)
//SC: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int sum =0;
        for(int i:nums) sum += i;
        int n = nums.length;
        return n*(n+1)/2 - sum;
        
    }
}