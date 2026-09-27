class Solution {
    public String reverseParentheses(String s) {
            Stack<Character> st = new Stack<>();
            for(int i=0;i<s.length();i++){
               char ch = s.charAt(i);
               if(s.charAt(i)!=')')
               st.push(ch);
               else if(s.charAt(i)==')'){
                    StringBuilder sb = new StringBuilder();
                    char c = 'a';
                    while(c!='(' && !st.isEmpty()){
                    c =st.pop();
                    if(c!='(')
                    sb.append(c);
                    }
                    String news=sb.toString();
                    for(int j=0;j<news.length();j++){
                        st.push(news.charAt(j));
                    }
                }
            } 
            StringBuilder ans = new StringBuilder();
            while(!st.isEmpty()){
                ans.append(st.pop());
            }   
            return ans.reverse().toString();    
    }
}