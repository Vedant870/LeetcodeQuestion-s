class Solution {
    public int gcd(int a, int  b){
        if(a==0||b==0){
            return Math.max(a,b);
        }
        int result = Math.min(a,b);
        while(result>0){
            if(a%result==0 && b%result==0){
                return result;
            }
            result--;
        }
        return 1;
    }
    public int gcdOfOddEvenSums(int n) {
        int odd = n*n;
        int even = n*(n+1);
        return gcd(odd,even);        
    }
}