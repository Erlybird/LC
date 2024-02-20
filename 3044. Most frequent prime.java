//TC: O(N^2)
//SC: O(N)
// solution: Check in all the directions for all the elements in the matrix
// check if they are prime and greater than 10 and add it to HashMap
// if the freq is greater or if the freq is same and the number is larger , then update the max_freq and Max_Number
// return max_Number, if no prime exists return -1;
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    int max_Number = Integer.MIN_VALUE;
    int max_freq = 0;
    public int mostFrequentPrime(int[][] mat) {
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
        for(int i =0; i< mat.length; i++){
            for(int j =0; j< mat[0].length; j++){
                for(int[] dir: dirs) {
                    addingElementToMap(mat,i,j,dir);
                }
            }
        }
        // if(max_Number == Integer.MIN_VALUE || max_Num)
        // for(int key: map.keySet()){
        //     System.out.println(key + " "+ map.get(key));
        // }
        return (max_Number == Integer.MIN_VALUE)? -1:max_Number;
    }
    
    private void addingElementToMap(int[][] mat, int i, int j, int[] dir){
        // new Stringbuilder or multiply by 10 and add mat[i][j]
        // append the mat[i][j] 
        // check if it's prime and greater than 10
        // append the digit in the direction and add it to HashMap and check if it's max

        
        // StringBuilder str = new StringBuilder();
        int num =0;
        int i_dir = dir[0];
        int j_dir = dir[1];
        
        while( i >= 0 && i < mat.length && j>=0 && j < mat[0].length){
            num = num*10 + mat[i][j];
            if(isPrime(num)){
                if(num > 10)
                {
                    map.put(num,map.getOrDefault(num,0)+1);
        if(map.get(num) == max_freq){
            if(max_Number < num){
                max_Number = num; 
            }
        }
                    if(map.get(num) > max_freq){
        
                max_freq = map.get(num);
                max_Number = num;
            }
                }
            }
            i += i_dir;
            j += j_dir;
        }
    }
    
    private boolean isPrime(int num){
        if(num<= 1) return false;
        if(num <= 3) return true;
        if(num %2 ==0 || num %3 ==0) return false;
        for(int i =5 ; i <= Math.sqrt(num); i= i+6){
            if(num % i == 0 || num % (i+2) == 0) return false;
        }
        return true;
    }
}