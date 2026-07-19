class Solution {
    public String smallestSubsequence(String s) {
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        Set<Character> set=new HashSet<>();
        Stack<Character> stk=new Stack<>();
        for(char ch:s.toCharArray()){
            freq[ch-'a']--;
            if(set.contains(ch)){
                continue;
            }
            while(!stk.isEmpty() &&
                  stk.peek()> ch &&
                  freq[stk.peek()-'a']>0){
                char removed =stk.pop();
                set.remove(removed);
            }
            stk.push(ch);
            set.add(ch);
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stk){
            sb.append(c);
        }
        return sb.toString();
    }
}