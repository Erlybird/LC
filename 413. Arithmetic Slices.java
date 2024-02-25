//TC: O(N)
//SC: O(N)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length <= 2)return 0;
        int left = 0;
        int right = 1;
        int k = nums[right]  - nums[left];
        int count = 2;

        List<Integer> subarrays = new ArrayList<>();
        while(right != nums.length -1){
            left++;
            right++;
            if(nums[right]-nums[left]== k){
                count++;
            }else{
                if(count >= 3) subarrays.add(count);
                count =2;
                k= nums[right]-nums[left];
            }
        }
        if(count >=3) subarrays.add(count);

        int sum = 0;

        for(int subarray: subarrays) sum += (subarray - 2)*(subarray - 1)/2; //formula

        return sum;
    }
}