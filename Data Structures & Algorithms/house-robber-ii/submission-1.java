class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int dpp[] = new int[n];

        if(n==0) 
            return 0;

        if(n==1)
            return nums[0];

        if(n==2)
            return Math.max(nums[0],nums[1]);


        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n-1; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        dpp[1] = nums[1];
        dpp[2] = Math.max(nums[1], nums[2]);

        for(int i=3; i<n; i++) {
            dpp[i] = Math.max(nums[i] + dpp[i-2], dpp[i-1]);
        }

        return Math.max(dpp[n-1], dp[n-2]);
        
    }
}
