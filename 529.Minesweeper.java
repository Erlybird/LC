//Time Complexity = O(8*M*N);
//Space Complexity = O(M*N)
//Method: BFS: because all the indices are connected we can do BFS or DFS.
// put the click in a queue and process it by counting the mines around it and
// imp: then if the mines are zero . i.e count =0 then only put its neighbours in the queue and iterate till the q is empty
// imp:Optimization: for every element we put in the queue, it's neighbours may be same, so we might adding a same neighbour multiple times in the queue. so we can maintain a visited matrix and only those which are not visited should be added to queue. Or we can change it's value to B prior hand to know it's already visited.
// Imp: converting an int to character is done by explicit casting but, it would give the character associated with that number, so add character 0 to the integer, which gives the ascii value of the integer count in character, so when casted will give character number as required.
class Solution {

    int[][] dirs;
    public char[][] updateBoard(char[][] board, int[] click) {

        dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1},{1,-1},{-1,1},{1,1},{-1,-1}};
        int m = board.length;
        int n= board[0].length;
        //if click is on Mine return with changing the board to X
        if(board[click[0]][click[1]]== 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        // add click to the queue and make it B
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{click[0],click[1]});
        board[click[0]][click[1]] = 'B';

        while(!q.isEmpty()){

            int[] curr = q.poll();
            //count the mines around it
            int count = countMines(board , curr[0],curr[1],m , n);
            //if count = 0, no need to change it's value and then add it's children to queue and make them 'B', so as not to add it again to the queue.
            if(count ==0) {
                // board[curr[0]][curr[1]] = 'B';
                for(int[] dirc: dirs){
                    int cr = dirc[0] + curr[0];
                    int cc = dirc[1] + curr[1];
                    if(cr >=0 && cr < board.length && cc >=0 &&
                            cc < board[0].length && board[cr][cc] == 'E'){
                        q.add(new int[]{cr,cc});
                        board[cr][cc] = 'B';
                    }
                }
            } else{
                //count !=0, change it's value to count
                board[curr[0]][curr[1]] = (char)(count + '0');
            }

        }
        return board;
    }
    //count mines
    private int countMines(char[][] board ,int i ,int j ,int m ,int n ){
        int count = 0;
        for(int[] dir : dirs){
            int nr = dir[0] + i;
            int nc = dir[1] + j;

            if(nr >=0 && nr < m && nc >=0 &&
                    nc < n && board[nr][nc] == 'M'){
                count++;
            }
        }
        return count;

    }
}