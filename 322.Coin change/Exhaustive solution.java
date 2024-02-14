//Solution: This is an exhaustive solution, so take the coins array and try the possibilities of arranging the coins to get the target.
// So if we take it in an organised way. there are two possibilites ; either to choose a coin or go to the next coin.
// This will give all the combinations of the coins till the target is reached.
// Now the objective is to write this code in DP to make it in less TC- mostly linear

//TC: 2^n exponential
//SC: recursive stack which would be equivalent to 2^n

class Solution {
    public int coinChange(int[] coins, int amount) {

        return helper(coins,amount,0,0);
    }
    private int helper(int[] coins, int target, int idx, int usedCoins){
        if(idx == coins.length || target < 0) return -1;
        else if(target == 0){

            return usedCoins;
        }else{
            //choose
            int case1 = helper(coins,target-coins[idx],idx,usedCoins+1);
            //not choose
            int case2 = helper(coins,target,idx+1,usedCoins);
// if case1= -1(couldn't find the target), min would be -1, which shouldn't be the answer
            if(case1== -1) return case2;
            if(case2 == -1) return case1;
            return Math.min(case1,case2);

        }
        //return -1; (Not necessary because this statement is not reached ever)
    }
}