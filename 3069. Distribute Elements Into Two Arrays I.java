// TC: O(N)
// SC: O(2N) 
class Solution {
    public int[] resultArray(int[] nums) {
        
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        
        for(int i= 2; i< nums.length; i++){
            if(arr1.get(arr1.size() - 1) > arr2.get(arr2.size() -1)){
                arr1.add(nums[i]);
            }else arr2.add(nums[i]);
        }
        
        int[] result = new int[nums.length];
        int k =0;
        for(int j =0; j<arr1.size(); j++){
            result[k] = arr1.get(j);
            k++;
        }
        
        for(int l =0; l < arr2.size(); l++){
            result[k] = arr2.get(l);
            k++;
        }
        return result;
        
    }
}