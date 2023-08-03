//Time Complexity = O(N);
//Space Complexity = O(1);
//Method: Greedy approach
//check the max indexing you can jump from index 0 and then in that interval check the next largest jump you can do and so-on until you reach last index
class Solution {
    public int jump(int[] nums) {
        //base
        if(nums.length < 2)return 0;
        int jumps = 1;
        int currInt = nums[0];
        int nextInt = nums[0];
        // int currIdx = 0;
        for(int i = 0; i< nums.length -1 ; i++){
            nextInt = Math.max(nextInt, i + nums[i]);
            if(i==currInt){
                currInt = nextInt;
                jumps++;
            }
        }
        return jumps;
    }
}