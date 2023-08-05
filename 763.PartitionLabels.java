//Time Complexity = O(N);
//Space Complexity = O(1); max size of HashMap is 26
//Method: Put all the last indexes of a character in a hashmap and iterate through the string, whenever the character at i and the last index of the character is also i, we can make a partition.
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c,i);
        }
        int max = 0;
        int prev =0;
        for(int i = 0; i<s.length(); i++){
            max = Math.max(max,map.get(s.charAt(i)));
            if(i==max){
                result.add(i-prev +1);
                prev = i+1;
            }
        }
        return result;
    }
}