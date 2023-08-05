import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        int maxConnections = 0;
        Queue<int[]> q = new LinkedList<>();
        int connected =0;
        int m = matrix.size();
        int n = matrix.get(0).size();
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,-1},{-1,1},{1,1},{-1,-1}};
        for(int r=0; r< m ; r++){
            for(int c = 0; c < n ; c++){
                if(matrix.get(r).get(c)==1){
                    connected = 1;
                    matrix.get(r).set(c,-1);
                    q.add(new int[]{r,c});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir: dirs){
                            int nr = curr[0]+dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr < m && nr >= 0 && nc < n && nc >= 0 && matrix.get(nr).get(nc) ==1){
                                matrix.get(nr).set(nc,-1);
                                q.add(new int[]{nr,nc});
                                connected++;
                            }
                        }
                    }

                }
                maxConnections = Math.max(maxConnections,connected);
            }
        }
        return maxConnections;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
