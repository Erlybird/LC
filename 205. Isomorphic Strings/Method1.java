//TC: O(N)
//SC : 2*O(N)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())return false;
        Map<Character,Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for(int i=0; i< s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if(!map1.containsKey(cs)){
                map1.put(cs,ct);
            }
            if(map1.get(cs) != ct) return false;

            if(!map2.containsKey(ct)){
                map2.put(ct,cs);
            }
            if(map2.get(ct) != cs) return false;
        }
        return true;
    }
}