//Brute Force Solution
class Solution {
    int maxi = 0;
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(nums[0]);
        helper(nums,0,0,0,-1);
        return maxi;

    }

    private void helper(int[] nums, int idx, int sum, int previousSum,int previousInt){
        if(idx== nums.length ) {
            maxi = Math.max(maxi,sum);
            return;
        }
        else{
            //not choose
            int k = idx;
            while(k<nums.length-1 && nums[k+1]==nums[idx]){
                k++;
            }
            if(k!= nums.length)
                helper(nums,k+1,sum,0,0);


            //choose
            if(nums[idx]-1 == previousInt){
                sum -= previousSum;
                previousSum =0;
            }
            // previousSum =0;
            int l = idx;
            while(l<nums.length -1 && nums[l+1]== nums[idx]){
                l++;
            }
            sum += (l-idx+1)*nums[l];
            previousSum = (l-idx+1) * nums[l];
            previousInt = nums[l];

            if(l!= nums.length) helper(nums,l+1,sum,previousSum,previousInt);

            //

        }
    }
}