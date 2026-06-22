class Solution {
    public int maxNumberOfBalloons(String text) {
        int fq[]= new int[26];
        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            fq[ch-'a']++;
        }
        int count=0;
        int min=Integer.MAX_VALUE;
        String str="balloon";
        if(fq['l'-'a']<2 || fq['o'-'a']<2){
            return 0;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(fq[ch-'a']==0){
                return 0;
            }
            if(ch=='l' || ch=='o'){
                if(Math.abs(fq[ch-'a']/2)<min){
                    min=fq[ch-'a']/2;
                }
            }
           else  if(fq[ch-'a']<min ){
                min=fq[ch-'a'];
            }
        }
        return min;
    }
}