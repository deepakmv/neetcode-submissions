class Solution {
    public int maxArea(int[] heights) {

        int maxArea = 0;

        for(int i=0, j=heights.length-1; i<j;) {
            int minHeight = Math.min(heights[i], heights[j]);
            int area = (j-i)*minHeight;

            if(area>maxArea){
                maxArea = area;
            }
            if(heights[i] <= heights[j]){
                i++;
            }
            else {
                j--;
            }
        }

        return maxArea;
        
    }
}
