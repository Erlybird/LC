// TC: O(N)
//SC: O(1)
// Solution: multiply the nums[num] by -1; and re traverse, if nums[num] > 0 ,implies it is a duplicate( twice), so add num inside a set(instead of list, as it will be added twice)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        // multiply the elements in the array with -1;
        
        for(int num: nums){
            nums[Math.abs(num) - 1] *= -1;
        }
        
        for(int num: nums){

            if(nums[Math.abs(num) - 1] > 0) set.add(Math.abs(num));
        }
        return new ArrayList<>(set);
    }
}