class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int curMin = 1, curMax = 1;

        if(n == 0) {
            return 0;
        }

        int max = nums[0];


        for(int i=0; i<n; i++) {
            int temp = curMax * nums[i];
            curMax = Math.max(Math.max(nums[i]*curMax, nums[i]*curMin),nums[i]);
            curMin = Math.min(Math.min(temp, nums[i]*curMin), nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}
