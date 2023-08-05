//Time Complexity = O(5N) ~ O(N)
//Space Complexity = O(N) hashmap + O(N) degree array
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        //Initialize Arraylists in each key of HashMap
        for(int i =0 ; i<numCourses;i++){
            map.put(i,new ArrayList<Integer>());
        }
        int[] degree = new int[numCourses];

        //update degree array and hashMap
        for(int[] preReq : prerequisites){
            degree[preReq[0]] += 1;
            li = map.get(preReq[1]);
            li.add(preReq[0]);
            map.put(preReq[1],li);

        }
        Queue<Integer> q = new LinkedList<>();

        //add initial independent courses to queue
        for(int i=0; i< numCourses; i++){
            if(degree[i]==0)q.add(i);
        }
        //base
        if(q.size() == 0) return false;

        while(!q.isEmpty()){
            //remove one element
            int curr = q.poll();
            li = map.get(curr);
            //process the element- get arraylist from map and decrease its degree in degree array

            for(int course: li){
                degree[course] -= 1;
                //if it's 0 then add it to queue
                if(degree[course] == 0)q.add(course);
            }
            map.remove(curr);
        }
        //if any valuein degree array != 0 return false
        for(int course: degree){
            if(course != 0) return false;
        }
        return true;
    }
}