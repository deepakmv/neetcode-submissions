class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character,Integer> charCountMap = new HashMap<>();

        char[] s1 = s.toCharArray();

        char[] t1 = t.toCharArray();

        for (int i=0; i<s1.length; i++) {
            if (charCountMap.containsKey(s1[i])){
                int val = charCountMap.get(s1[i]);
                charCountMap.put(s1[i], val+1);
            }
            else {
                charCountMap.put(s1[i], 1);
            }
        }

        for (int i=0; i<t1.length; i++) {
            if (charCountMap.containsKey(t1[i])){
                int val = charCountMap.get(t1[i]);
                charCountMap.put(t1[i], val-1);
            }
            else {
                charCountMap.put(t1[i], 1);
            }
        }

        // Loop through values only
        for (Integer value : charCountMap.values()) { 
            if(value != 0) {
            return false;
            }
        }
        return true;
    }
}
