class Solution {
    public int lengthOfLongestSubstring(String s) {

        char[] ch = s.toCharArray();

        int[] test = new int[128];
        Arrays.fill(test, -1);

        int maxLength = 0;
        int start = 0;
        for(int i=0; i<ch.length; i++) {
            if(test[ch[i]] >= start) {
                start = test[ch[i]] + 1;
            }
            test[ch[i]] = i;
            int length = i - start + 1;
            maxLength = (length>maxLength) ? length : maxLength;
        }
        return maxLength;
        
    }
}
