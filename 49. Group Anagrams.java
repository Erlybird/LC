// for an anagram, the prime multiple of each character of the string would be same.
// use double for product instead of int, because integer might go out of bounds
//TC: O(kN) k for the number of characters in a string
//SC: O(N)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = new int[]{2,3,5,7,11,13,17,19,
                23,29,31,37,41,43,47,
                53,59,61,67,71,73,79,83,89,97,
                101};
        Map<Double,List<String>> map = new HashMap<>();

        for(String str:strs){
            double product = 1.0;
            for(int i=0; i<str.length();i++){
                char c = str.charAt(i);
                product *= primes[c-'a'];
            }
            if(!map.containsKey(product)){
                map.put(product,new ArrayList<>());
            }
            map.get(product).add(str);
        }

        return new ArrayList(map.values());
    }
}