//Time Complexity = O(N^2)
//Space Complexity = O(N);
//Method: taller person[1] value is not affected by howmany ever short person stand before him, so place the taller person in the queue first according to their order mentioned in 1st index value and then scooch them whenever a smaller person comes inbetween.

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //sort the array in descending order
        Arrays.sort(people,(a,b) -> {
            if(a[0]==b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();

        for(int i =0; i<people.length ; i++){
            int[] person = people[i];
            result.add(person[1],person);
        }
        int[][] finalResult = new int[people.length][2];
        for(int i =0; i < people.length ; i++){
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}