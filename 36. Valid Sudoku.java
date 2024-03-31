//TC: O(N^2)
//SC: O(N^2)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        
        // System.out.println(row[0][0]);
        for(int i =0; i< board.length; i++){
            for(int j =0; j < board[0].length; j++){
                char c = board[i][j];
                
                if(c == '.') continue;
                else{
                    int num = Character.getNumericValue(c);
                    
                    if(row[i][num-1])return false;
                    else row[i][num-1] = true;
                    
                    if(col[j][num-1])return false;
                    else col[j][num-1] = true;
                    
                    int idx = (i/3)*3 + j/3;
                    
                    if(box[idx][num-1])return false;
                    else box[idx][num-1] = true;
                }
            }
        }
        return true;
    }
}