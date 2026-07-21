class Solution{
    public int maxActiveSectionsAfterTrade(String s) {
        int i=0;
        while(i<s.length()&&s.charAt(i)=='1') i++;
        if(i==s.length()) return s.length();
        int blockX=0;
        int blockY=0;
        List<List<Integer>> list=new ArrayList<>();
        int zeros=0;
        int x=i;
        int y=i;
        while (i<s.length()) {
            while(i<s.length()&&s.charAt(i)=='0') {
                i++;
                y++;
            }
            list.add(Arrays.asList(x,y));
            while (i < s.length() && s.charAt(i) == '1') {
                i++;
            }
            x=i;
            y=i;
        }
        int max=0;
        for(int var=0;var<list.size()-1;var++){
            List<Integer> l1=list.get(var);
            List<Integer> l2=list.get(var+1);
            max=Math.max(l2.get(1)-l1.get(0)-(l2.get(0)-l1.get(1)),max);
        }
        for(int k=0;k<s.length();k++){
            if(s.charAt(k)=='1') max++;
        }
        return max;
    }
}