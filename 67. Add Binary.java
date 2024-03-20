//TC: O(N)
//SC: O(1)
class Solution {
    public String addBinary(String a, String b) {

        
        int sum =0;
        int idx =0;
        
        StringBuilder result = new StringBuilder();
        
        while( sum != 0 || idx< Math.max(a.length(),b.length())){
            
            int s1= 0;
            if(idx < a.length())s1 = Character.getNumericValue(a.charAt(a.length() -1 -idx));
            int s2=0;
            if(idx < b.length()) s2 = Character.getNumericValue(b.charAt(b.length()-1-idx));
            
            
            sum+= s1 +s2;
            if(sum > 1){
                result.append(String.valueOf(sum%2));
                sum = sum/2;
            }else{
                result.append(String.valueOf(sum));
                sum=0;
            }
          idx++;  
        }
       
        return result.reverse().toString();
    }
    

}