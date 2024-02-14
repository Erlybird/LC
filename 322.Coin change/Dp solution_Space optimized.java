// We have not taken Integer.MAX_VALUE because, when we add 1 to int max value it becomes Integer out of bounds and returns Integer.MIN_VALUE. So we used a large number.
//In here we still did the exhaustive solution
// TC: O(M*N)
//SC: O(N)
class Solution {
    public int coinChange(int[] coins, int amount) {
        // int[][] dp = new int[coins.length+1][amount+1];
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int j=1; j< amount+1; j++){
            dp[j] = 99999;
        }
        int i = 1;
        // for(int i =1; i < coins.length+1 ; i++ ){
        while(i<coins.length+1){
            for(int j = 0; j< amount+1; j++){
                if(j>= coins[i-1]){
                    //Taking the min amount of the above element which is dp[j]and the element at which the present denomination can be added so that the amount is zero.dp[j-coins[i-1]]
                    dp[j] = Math.min(dp[j-coins[i-1]] + 1, dp[j]);
                }else{
                    // for all the amount less than the denomination
                    dp[j] = dp[j];
                }
            }
            i++;
        }
        if(dp[amount]== 99999)return -1;
        return dp[amount];
    }

}