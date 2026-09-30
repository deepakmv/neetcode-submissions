class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> bucket = new HashMap<>();

        for(int i=0; i<nums.length ; i++) {
           if(bucket.containsKey(nums[i])) {
                int val = bucket.get(nums[i]);
                bucket.put(nums[i], val+1);
           }
           else {
                bucket.put(nums[i], 1);
           }
        }


        List<Integer>[] freqList = new List[nums.length + 1];

        for (int key : bucket.keySet()) {
            int val = bucket.get(key);

            if (freqList[val] == null) {
                freqList[val] = new ArrayList<>();
            }
            freqList[val].add(key);
        }

        int[] results = new int[k];
        int x = 0;
        for(int j = freqList.length - 1; j >= 0 && x < k; j--) {
            if (freqList[j] != null) {
                for(int num : freqList[j]) {
                    results[x++] = num;
                    if (x == k) break;
                }
            }
        }
        return results;
    }
}
