//TC: O(N)
//SC: O(N)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int i;
        for( i = 0; i < nums.length; i++){
            if(nums[i] >=0) break;
        }
        int j=0;
        if(i != 0) j =i;
        int[] result = new int[nums.length];
        int k = 0;
        
        while( k < nums.length ){
            if(j==0) {
                result[k] = nums[i]*nums[i];
                i++;
                     }
            else if( i == nums.length ){
                result[k] = nums[j-1]*nums[j-1];
                j--;
            }
            else if(Math.abs(nums[j-1]) < nums[i] ){
                result[k] = nums[j-1] * nums[j-1];
                j--;
            }else{
                result[k] = nums[i]*nums[i];
                i++;
            }
            k++;
            
        }
        return result;
    }
}