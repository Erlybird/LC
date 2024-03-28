//TC: O(N)
//SC: O(N)
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        // put elements in hashmap till anyof the elements frequency <= k
        // if by adding any element the frequency is becoming k+1, then increase the left pointer
        // till nums[left] == nums[right+1] and left < right
        // then increase the right pointer
        // have maxLength counter
        //right counter < nums.length
        
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int left =0;
        int right =0;
        int maxLength =0;

        while(right < nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.get(nums[right]) > k){
                map.put(nums[left], map.get(nums[left])-1);
                 left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
                right++;
        }
        return maxLength;
    }
}