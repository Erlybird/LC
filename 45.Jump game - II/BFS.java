//Time Coplexity =O(N^N), a bit optimised because we are removing already calculated ones
//Space complexity = O(N) + O(N);
//BFS
//Method: Maintain a count value and add root's children to the queue and a set; when children value is nums.length -1, return the count(i.e the min jumps needed to reach last index)
class Solution {
    public int jump(int[] nums) {
        //base
        if(nums.length < 2)return 0;
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0); set.add(0);
        int count =0;
        while(!q.isEmpty()){
            int size = q.size();
            //maintain tree level
            for(int i =0; i < size; i++){
                int currIdx = q.poll();

                //check for each index the highest it can jump to
                for(int j =0 ; j<= nums[currIdx]&& currIdx +j < nums.length; j++){
                    //if last element is reach return count +1
                    if(currIdx + j >= nums.length -1) return count +1 ;

                    //if idx not processed before then add it to the queue
                    if(!set.contains(currIdx+j)){
                        q.add(currIdx+j);
                        set.add(currIdx + j);
                    }
                }

                // System.out.println(q);

            }
            //increase the count after completing one level of tree
            count++;
            // System.out.println(count);
        }
        return count;
    }
}