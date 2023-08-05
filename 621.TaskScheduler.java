//Time Complexity = O(N)
//Space complexity - O(1) because there are fixed characters and map size can't be greater than no. of characters even if there are million tasks
//Method: Schedule the max frequency of the tasks firstly with n gaps between them, all the others have to be filled in them.
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxCount =0;
        int maxFreq = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c: tasks ){
            map.put(c, map.getOrDefault(c,0)+1);
            if(map.get(c) > maxFreq){
                maxCount = 1;
                maxFreq = map.get(c);
            }
            else if(map.get(c) == maxFreq){
                maxCount++;
            }

        }
        int partitions = maxFreq - 1;
        int slotsAvailable = partitions * (n -(maxCount - 1));
        int pending = tasks.length - maxFreq*maxCount;
        int idle = Math.max(0,slotsAvailable - pending);
        return tasks.length + idle;

    }
}