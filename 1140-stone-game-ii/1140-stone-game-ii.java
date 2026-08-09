class Solution {
    int dp[][][];
    int solve(int[]piles,int person,int i,int m){
        if(i>=piles.length)
          return 0;
        if(dp[person][i][m]!=-1)
          return dp[person][i][m];
        int ans=person==1?-1:Integer.MAX_VALUE;
        int stone=0;
        for(int x=1;x<=Math.min(2*m,piles.length-i);x++){
            stone+=piles[i+x-1];
            if(person==1)  
            ans=Math.max(ans,stone+solve(piles,0,i+x,Math.max(m,x)));
            else
            ans=Math.min(ans,solve(piles,1,i+x,Math.max(m,x)));          
        }
        return dp[person][i][m]=ans;
    }
    public int stoneGameII(int[] piles) {
        dp=new int[2][101][101];
        for(int[][] a:dp)
          for(int[] b:a)
            Arrays.fill(b,-1);
        
        return solve(piles,1,0,1);
    }
}