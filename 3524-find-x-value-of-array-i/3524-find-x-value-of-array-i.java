class Solution {
    int n;
    public long[] resultArray(int[] nums, int k) {
        long[] ans=new long[k];
        n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=nums[i]%k;
        }
        for(int x=0;x<k;x++){
            long[][] dp=new long[n+1][k+1];
            for(long[] a: dp){
                Arrays.fill(a, -1);
            }
            ans[x]=solve(0, k, x, nums, k, dp);
        }
        return ans;
    }
    long solve(int idx, int k, int x, int[] nums, int prevProd, long[][] dp){
        if(idx==n) return 0;
        if(dp[idx][prevProd]!=-1) return dp[idx][prevProd];
        long skip=0;
        long take=0;
        if(prevProd==k){
            skip=solve(idx+1, k, x, nums, prevProd, dp);
        }
        int currProd=0;
        if(prevProd==k){
            currProd=nums[idx];
        }
        else{
            currProd=(int)(prevProd*nums[idx])%k;
        }

        if(currProd==x) take+=1;
        take+=solve(idx+1, k, x, nums, currProd, dp);
        return dp[idx][prevProd]=skip+take;
    }
}