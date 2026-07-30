class Solution {
    public int minimumPushes(String word) {
        int c=0;
        int res=0;
        for(char ch : word.toCharArray()){
            if(ch=='1' || ch=='*' || ch=='#'){
                continue;
            }
            else{
            c++;
            }
        }
        int rem=c%8;
        int quo=c/8;
        int temp=quo;
        while(quo>0){
            res+=quo*8;
            quo--;
        }
        int x=temp+1;
        if(rem!=0){
        res+=(rem*x);
        }
        return res;
    }
}