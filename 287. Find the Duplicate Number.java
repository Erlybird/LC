//TC: O(N)
//SC: O(1)
// a cycle is created if there are duplicate numbers in an array. so the start of the cycle is the duplicate number.
// mathematically a cycle can be found if f(x), f(f(x)), f(f(f(x))).... doesn't end ever.
// So if we can hare two pointer which have f(x) and f(f(x)) speed, then they are bound to meet and total length travelled by hare = 2*tortoise,
//F + C + a = 2 ( F + a) , F - first elements outside the circle; C - length of the circle , a - length from the start of circle and the point at which both intersect. ( at this point both values would be same)
// F = c- a +> Now, both the pointers are at length a after the start of circle, so the remaining length of the circle = c-a; 
//and if one pointer starts from nums[0], they have to meet at the start of the circle with this equation.
class Solution {
    public int findDuplicate(int[] nums) {
        
        int tortoise = nums[0];
        int hare = nums[0];

        // find the intersection point, 
          do {

            tortoise = nums[tortoise];
            hare = nums[nums[hare]];

        } while (tortoise != hare);
        
        
        
        
        // to find the start of cycle
        
        tortoise = nums[0];
        
        while(tortoise != hare){
            hare = nums[hare];
            tortoise = nums[tortoise];
        }
        
        return tortoise;
    }
}