class Solution {
    int mod = 1000000007;
    Integer[][] dp;
    public int numberOfSets(int n, int k) {
        this.dp = new Integer[n+1][k+1];
        return helper(n, k);
    }
    public int helper(int n, int k){
        if(k== 0 || n-1 == k){
            return 1;
        }
       
        if(dp[n][k] != null){
            return dp[n][k];
        }
        long sum = 0;
        sum += helper(n-1, k);
        for(int i = n-1; i >= k; i--){
            sum += helper(i, k-1);
           
        }
        sum %= mod;
        dp[n][k] = (int)sum;
        return (int)sum;
    }
}