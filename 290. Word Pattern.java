//TC: (3N)
//SC: O(N)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        // List<String> strArr = new ArrayList<String>();
        int n = pattern.length();
        // while(n-1!=0){
        //     String k = s.split(" ");
        //     strArr.add(k);
        // }
        String[] strArr = s.split(" ",0);
        if(strArr.length != n) return false;
        Map<String,Character> map2 = new HashMap<>();
        Map<Character,String> map1 = new HashMap<>();

        for(int i =0; i< pattern.length() ; i++){
            if(map1.containsKey(pattern.charAt(i))){
                if(!map1.get(pattern.charAt(i)).equals(strArr[i]))return false;
            }else{map1.put(pattern.charAt(i),strArr[i]);}

            if(map2.containsKey(strArr[i])){
                if(map2.get(strArr[i]) != pattern.charAt(i))return false;
            }else{map2.put(strArr[i],pattern.charAt(i));}
        }
        return true;
    }
}