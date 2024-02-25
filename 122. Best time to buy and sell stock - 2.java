// TC: O(N)
// SC: O(1)
// Solution: max profit is achieved when profit at everywhere is added
class Solution {
    public int maxProfit(int[] prices) {

        int sum =0;
        for(int i=0; i< prices.length - 1; i++){
            if(prices[i+1] > prices[i]) sum += prices[i+1] - prices[i];
        }
        return sum;
    }
}