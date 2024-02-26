class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num) >2)return false;
        }
        return true;
    }
}