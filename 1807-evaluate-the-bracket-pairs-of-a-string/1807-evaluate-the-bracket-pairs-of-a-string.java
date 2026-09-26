class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        int st=0;
        int n=s.length();
        int cnt=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                cnt++;
                st=i;
            }
            if(ch==')'){
                cnt--;
                if(cnt==0){
                    String sub=s.substring(st+1,i);
                    if(map.containsKey(sub)){
                        sb.append(map.get(sub));
                    }
                    else{
                        sb.append('?');
                    }
                }
                continue;
            }
            if(cnt==0){
                sb.append(ch);
            }
            
        }
        return sb.toString();
    }
}