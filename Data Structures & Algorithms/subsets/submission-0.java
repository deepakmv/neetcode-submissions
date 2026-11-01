class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        
        dfs(0,nums,resultList,subResult);

        return resultList;
    }

    public void dfs(int i, int[]nums, List<List<Integer>> resultList, List<Integer> subResult) {
        
        if(i >= nums.length) {
            resultList.add(new ArrayList<>(subResult));
            return;
        }

        subResult.add(nums[i]);
        dfs(i+1, nums, resultList, subResult);
        subResult.remove(subResult.size()-1);
        dfs(i+1, nums, resultList, subResult);
    }
}
