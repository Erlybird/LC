//TC: O(M*N)
//SC: O(M*N)
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int[][] horizontal = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid[0].length; i++){
            horizontal[0][i] = grid[0][i];
        }
            
        for(int i =0; i < grid[0].length; i++){
        for(int j =1; j< grid.length; j++){
            horizontal[j][i] = horizontal[j-1][i] + grid[j][i];
        }
        }
        
        
        
        int count =0;
        
        for(int i = 0; i < grid.length; i++){
            int sum= 0;
            for(int j =0; j < grid[0].length; j++){
                sum += horizontal[i][j];
                if(sum <= k)count++;
                else break;
            }
        }
        return count;
    }
}