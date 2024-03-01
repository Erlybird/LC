//Time Complexity: O(N)
//SC: O(N)
class Solution {
    public String maximumOddBinaryNumber(String s) {
        
        StringBuilder k = new StringBuilder();
        
        for(int t = 0; t < s.length() ; t++){
            k.append(s.charAt(t));
        }
        
        int j = k.length()-1;
        int i =0;
        
        while(i <=j){
            if(k.charAt(i)=='0'){
                swap(k,i,j);
                j--;
            }
            else i++;
        }
        
        swap(k,j,k.length()-1);
        
        return k.toString();
    }
    
    private void swap(StringBuilder k , int i, int j){
        
        char temp = k.charAt(i);
        k.setCharAt(i,k.charAt(j));
        k.setCharAt(j,temp);
        
    }
}