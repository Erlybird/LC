//TC: O(N)
//SC : 2*O(N)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Character [] sArray = new Character[96];
        Character [] tArray = new Character[96];

        //base case
        if(s.length() != t.length())return false;

        for(int i =0; i< s.length(); i++){
            Character sc = s.charAt(i);
            Character st = t.charAt(i);
            // System.out.println("i : " + i + " sc : "+ sc + " st : "+ st);

            if(sArray[sc-' '] == null){
                sArray[sc-' '] = st;
            }else{
                if(sArray[sc-' '] != st) return false;
            }


            if(tArray[st-' '] == null){
                tArray[st-' '] = sc;
            }else{
                if(tArray[st-' '] != sc) return false;
            }
        }
        return true;
    }
}