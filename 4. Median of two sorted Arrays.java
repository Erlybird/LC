//TC: O(M+N)
//SC: O(M+N)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] fi = combination(nums1,nums2);
        // System.out.println(fi[(fi.length-1)/2] + " " + fi[(fi.length-1)/2 + 1]);
        double result = (fi.length %2 !=0)? fi[fi.length/2]:((fi[(fi.length-1)/2])+(fi[(fi.length-1)/2 + 1] ))/2.0;
        
        return result;
    }
    
    private int[] combination(int[] nums1, int[] nums2){
        int idx =0;
        int i =0;
        int j =0;
        int[] result = new int[nums1.length + nums2.length];
        while(idx < nums1.length + nums2.length){
            // System.out.println(idx);
            if(i < nums1.length && j < nums2.length){
                if(nums1[i] <= nums2[j]){
                    result[idx] = nums1[i];
                    i++;
                }else{
                    result[idx] = nums2[j];
                    j++;
                }
                idx++;
            }
            else if(i == nums1.length){
                while(j != nums2.length){
                    result[idx] = nums2[j];
                    idx++;
                    j++;
                }
                
            }else{
                while(i != nums1.length){
                    result[idx] = nums1[i];
                    idx++;
                    i++;
                }
                
            }
        }
        return result;
    }
}