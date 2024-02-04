//TC: O(NlogN)-sorting + O(N)
// SC: O(N) for the heap
// Solution: Firstly sort the intervals based on the start times, and we need a new room if the meeting isn't over by the start time of another meeting, so we can add the end times in a minHeap, so any room with lesser meeting closing time than the start time of another meeting , it can be taken out from the heap and the new meeting can be added there.
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        //sorting the intervals based on start time
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count =0;
        //keep the end times in a min binary heap
        for(int i =0; i< intervals.length; i++){
            if(minHeap.isEmpty() || minHeap.peek() > intervals[i][0]){
                minHeap.add(intervals[i][1]);
                count++;
            }else{
                minHeap.poll();
                minHeap.add(intervals[i][1]);
            }
        }
        return count;
    }
}