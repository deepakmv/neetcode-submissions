class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String s : strs) {
            char[] ch = s.toCharArray();

            int[] charCount = new int[26];
            Arrays.fill(charCount, 0);

            for(int i=0; i<ch.length; i++){
                if (ch[i] >= 'a' && ch[i] <= 'z') {
                    charCount[ch[i] - 'a']++; 
                }
            }
            
            char[] cArr = new char[52];
            for(int i=0,j=0; i<26; i++) {
                if(charCount[i] > 0) {
                    cArr[j] = (char) (i + 'a') ;
                    j++;
                    cArr[j] = (char) charCount[i];
                    j++;
                }
            }
            String keyString = new String(cArr);
            if(anagramMap.containsKey(keyString)) {
                List<String> stringList = anagramMap.get(keyString);
                stringList.add(s);
                anagramMap.put(keyString,stringList);
            }
            else {
               List<String> stringList = new ArrayList<>();
               stringList.add(s);
               anagramMap.put(keyString,stringList);
            }
        }

        List<List<String>> finalList = new LinkedList<>();
        for(List<String> stringList : anagramMap.values()) {
            finalList.add(stringList);
        }
        return finalList;
    }
}
