// We have not taken Integer.MAX_VALUE because, when we add 1 to int max value it becomes Integer out of bounds and returns Integer.MIN_VALUE. So we used a large number.
//In here we still did the exhaustive solution
// TC: O(M*N)
//SC: O(M*N)- we can optimise it O(N)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 0;
        for(int i=1; i< amount+1; i++){
            dp[0][i] = 99999;
        }
        for(int i =1; i < coins.length+1 ; i++ ){
            for(int j = 0; j< amount+1; j++){
                if(j>= coins[i-1]){
                    //Taking the min amount of the above element and the element at which the present denomination can be added so that the amount is zero.
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]] + 1, dp[i-1][j]);
                }else{
                    // for all the amount less than the denomination
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[coins.length][amount]== 99999)return -1;
        return dp[coins.length][amount];
    }

}