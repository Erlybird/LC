//TC and SC :O(M*N)
//Solution: Write conditions for the directions of the movement; This can also be solved by taking variable, left, right, up and down and keeping the while condition as (left <= right && up <= down) instead of idx < m*n
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int k = n;
        int l = m;
        
        int idx =0;
        int i=0;
        int j =0;
        
        int dir = 1;
        
        while(idx < m*n){
            result.add(matrix[i][j]);
            // System.out.println(i + " "+ j+" "+ dir);
            idx++;
            if(dir == 1){
             if(j==k-1){
                 i=i+1;
                 dir = 2;
                 k--;
             }else{
                 j=j+1;
             }
            }else if(dir == 2){
                if(i == l-1){
                    j=j-1;
                    dir = 3;
                    l--;
                }else{
                    i=i+1;
                }
            }else if(dir == 3){
                if(j == n-k-1){
                    dir = 4;
                    i = i-1;
                }else{
                    j= j-1;
                }
            }else if(dir ==4){
                if(i == m - l){
                    dir = 1;
                    j=j+1;
                }else{
                    i--;
                }
            }
        }
        return result;
    }
}