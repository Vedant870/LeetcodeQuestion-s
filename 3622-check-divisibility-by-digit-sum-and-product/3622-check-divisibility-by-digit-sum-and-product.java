class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,product=1,copy=n;
        while (copy>0) {
            int digit=copy%10;
            copy-=digit;
            copy/=10;
            sum+=digit;
            product*=digit;
        }
        return(n%(sum+product))==0 ? true : false;
    }
}