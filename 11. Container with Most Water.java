// TC : O(N)
// SC : O(1)
class Solution {
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length -1;
        int maxArea =0;
        while(left <= right){
            int area = (right - left)* Math.min(height[left],height[right]);
            if(height[left] <= height[right]){

                left++;
            }else{
                right--;
            }
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}