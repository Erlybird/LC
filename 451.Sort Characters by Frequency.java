//Time Complexity = O(NlogN)
//Space Complexity = O(N)
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map1 = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        }

        List<Character> array = new ArrayList<>(map1.keySet());
        Collections.sort(array,(a,b) -> map1.get(b) - map1.get(a));

        StringBuilder result = new StringBuilder();

        for(char c: array){
            int freq = map1.get(c);
            while(freq > 0){
                result.append(c);
                freq--;
            }
        }
        return result.toString();
    }
}