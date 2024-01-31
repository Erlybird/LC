/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
//TC = O(logN)+ O(logN)
//SC = O(1)
// Sol: Find the range in which the target lies and then do binary search
class Solution {
    public int search(ArrayReader reader, int target) {
        int l =0;
        int r = 1;
        while(reader.get(r)<= target){
            l=r;
            r=2*r;
        }
        return binarySearch(reader,l,r, target);
    }

    private int binarySearch(ArrayReader reader, int l , int r , int target){

        while(l <= r){
            int mid = l + (r - l)/2;
            if(reader.get(mid)==target)return mid;
            else if (reader.get(mid) > target) r = mid -1;
            else l = mid + 1;
        }
        return -1;
    }
}