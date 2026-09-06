class Solution {
    public int helper(String s , String t , int s_idx , int t_idx , int[][] dp ){
        if(t_idx == t.length()) return 1;
        if(s_idx == s.length()) return 0;
        if(dp[s_idx][t_idx] >-1) return dp[s_idx][t_idx] ; 
        int pick = 0;
        if(s.charAt(s_idx) == t.charAt(t_idx))  pick+= helper(s,t,s_idx+1 , t_idx +1,dp);
        return dp[s_idx][t_idx] = pick + helper(s,t,s_idx+1 , t_idx ,dp); 
 
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] arr:dp)Arrays.fill(arr , -1);
        return helper(s,t,0,0,dp);
    }
}