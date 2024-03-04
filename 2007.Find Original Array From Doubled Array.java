// TC: O(NlogN)
//SC : O(N)
class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length %2 != 0)return new int[0];
        Arrays.sort(changed);
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[changed.length /2];
        Arrays.fill(result,-1);
        
        for(int num: changed){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int count = 0;
        int idx = 0;
        for(int num:changed){
            if(num == 0){
                count++;
                if(count == 2){
                    result[idx] = 0;
                    idx++;
                    count = 0;
                }
            }
            else if(!map.containsKey(num))continue;
            else if(map.containsKey(2 * num)){
                result[idx] = num;
                idx++;
                if(map.get(num) == 1 ) map.remove(num);
                else map.put(num,map.get(num)-1);
                
                                if(map.get(2 * num) == 1 ) map.remove(2 * num);
                else map.put(2 * num,map.get(2 * num)-1);
                
            }
        }
        
        if(result[changed.length/2 -1] == -1)return new int[0];
        return result;
    }
}