//TC: O(N)
//SC: O(1)
class Solution {
    public int maxFrequencyElements(int[] nums) {
        if(nums.length ==0) return 0;
        Arrays.sort(nums);
        int frequencies = 1;
        int maxCount = 1;
        int count =1;
        for(int i =1; i< nums.length ; i++){
            if(nums[i]== nums[i-1]){
                count++;    
            }else{
                count = 1;
            }
              if(count == maxCount) frequencies += count;
                else if(count > maxCount) {
                    maxCount = count;
                    frequencies = count;
                }
        }
        return frequencies;
    }
}