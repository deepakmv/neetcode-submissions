class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> items = new HashMap<>();

        for(int i=0; i< nums.length; i++) {

            int diff = target - nums[i];
            if(items.containsKey(diff)) {
                int[] ans = new int[2];
                ans[0]= items.get(diff);
                ans[1] = i;
                return ans;
            }
            items.put(nums[i], i);

        }
        return null;
    }
}
