//TC: O(NlogN)
//SC: O(N)
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // Set<Integer> result = map.keySet();
        Integer[] nums = map.keySet().toArray(new Integer[0]);
        Arrays.sort(nums, (a,b)-> map.get(a) - map.get(b));
        int i =0;
        // System.out.println(nums[0] + " "+ nums[1]+" "+ nums[2]);
        while(k>0 && i < nums.length){
            if( k>= map.get(nums[i])) {
                k = k-map.get(nums[i]);
                map.remove(nums[i]);
            }

            i++;

        }

        return map.keySet().size();
    }
}