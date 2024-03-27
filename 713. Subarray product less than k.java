//TC: O(N)
//SC: O(1)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int pointerB =0;
        int pointerA = 0;
        int count =0 ;
        int product = 1;
        
        while(pointerB < nums.length){
            product *= nums[pointerB];
           
                while(product >= k && pointerA <= pointerB){
                product /= nums[pointerA];
                    pointerA++;
                
            }
            count += pointerB - pointerA + 1;
                pointerB++;

        }
        return count;
    }
}