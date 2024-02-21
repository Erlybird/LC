//Solution: write down the equations when the direction has to be reversed.
//TC: O(M*N)
// SC: O(M*N) result array
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[] result = new int[m*n];

        int i = 0;
        int j = 0;
        int idx = 0;
        boolean dir = true;

        while(idx < m*n){
            result[idx] = mat[i][j];
            idx++;
            if(dir)
            {// up
                if(j== n-1 )
                {// First this has condition has to be checked because array will go out of bounds at [0][m-1] if this is not checked first
                    i = i+1;
                    dir = false;
                }else if(i==0 )
                {
                    j = j+1;
                    dir = false;
                }else
                {
                    i = i -1;
                    j = j+1;
                }
            }else
            {// down
                if(i == m-1 )
                {
                    j = j+1;
                    dir = true;
                }else if(j==0 )
                {
                    i = i+1;
                    dir = true;
                }else
                {
                    i = i+1;
                    j = j-1;
                }
                
            }
        }
        return result;
    }
}