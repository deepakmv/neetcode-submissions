class Solution {
    public boolean isValid(String s) {

        Set<Character> open = new HashSet<>();
        open.add('(');
        open.add('{');
        open.add('[');

        Set<Character> close = new HashSet<>();
        close.add(')');
        close.add('}');
        close.add(']');

        Map<Character,Character> symMap = new HashMap<>();
        symMap.put(')','(');
        symMap.put('}','{');
        symMap.put(']','[');

        
        Stack<Character> st = new Stack<>();

        char[] stringArray = s.toCharArray();

        for(char ch : stringArray) {

            if(open.contains(ch)) {
                st.push(ch);
            }

            if(close.contains(ch) && st.isEmpty()) {
                return false;
            }

            if(close.contains(ch) && !st.isEmpty()) {
                char sym = symMap.get(ch);
                char top = (char)st.peek();
                if(top != sym) {
                    return false;
                }
                else {
                    st.pop();
                }
            }
        }

        if(st.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}
