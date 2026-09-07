class Solution {
    public int distinctSubseqII(String s) {
        int MOD=1_000_000_007;
        int[] dp=new int[26];
        for (char c:s.toCharArray()) {
            int sum=0;
            for (int x:dp) {
                sum=(sum+x)%MOD;
            }
            dp[c-'a'] =(sum +1)%MOD;
        }
        int ans=0;
        for (int x:dp) {
            ans=(ans+x)%MOD;
        }
        return ans;
    }
}