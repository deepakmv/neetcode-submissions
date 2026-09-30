class Solution {
    public int trap(int[] height) {

        int prefix[] = new int[height.length];

        int suffix[] = new int[height.length];

        int prefMax=0;
        for(int i=0; i<height.length; i++) {
            if(height[i]>prefMax) {
                prefix[i] = height[i];
                prefMax = height[i];
            }
            else {
                prefix[i] = prefMax;
            }
        }

        int suffMax=0;
        for(int i=height.length-1; i>=0; i--) {
            if(height[i]>suffMax) {
                suffix[i] = height[i];
                suffMax = height[i];
            }
            else {
                suffix[i] = suffMax;
            }
        }

        int waterTrapped = 0;
        for(int i=0; i<height.length; i++) {
            int waterAtIndex = Math.min(prefix[i], suffix[i]) - height[i];
            waterTrapped += waterAtIndex;
        }

        return waterTrapped;
    }
}
